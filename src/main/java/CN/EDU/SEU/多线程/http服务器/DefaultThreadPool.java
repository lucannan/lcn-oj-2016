package CN.EDU.SEU.多线程.http服务器;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 实现一个简单的线程池
 * Created by LCN on 2016/4/22.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //一个工作队列，会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    //如果工作者列表是空的, 那么就wait
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知外部对workerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }

                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception ex) {

                    }
                }
            }
        }


        public void shutdown() {
            running = false;
        }

    }

    //初始化线程的工作者
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }


    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    @Override
    public void excute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            //限制新增加的worker数量不能超过最大值
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - num;
            }

            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workerNum");
            }

            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
}
