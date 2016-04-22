package CN.EDU.SEU.多线程.http服务器;

/**
 * Created by LCN on 2016/4/22.
 */
public interface ThreadPool<Job extends Runnable>{

    //执行一个Job, 这个Job需要实现Runnable
    void excute(Job job);
    //关闭线程池
    void shutdown();
    //增加工作者线程
    void addWorkers(int num);
    //减少工作者进程
    void removeWorker(int num);
    //得到正在等待执行的任务的个数
    int getJobSize();
}
