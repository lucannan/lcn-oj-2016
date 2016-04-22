package CN.EDU.SEU.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程优先级
 * p85
 * Created by LCN on 2016/4/22.
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart){
                /**
                 * yield：如果知道已经完成了在run()方法的循环的一次迭代过程中所需要的工作，
                 * 就可以给线程调度一个机制暗示：
                 * 我的工作已经做的差不多了，可以让给别的线程使用CPU了。
                 * 通过调用yield()来实现。
                 */
                Thread.yield();
            }

            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int priority = i < 5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread :" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs){
            System.out.println(job.priority + " " + job.jobCount);
        }
    }
}
