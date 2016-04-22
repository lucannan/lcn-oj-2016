package CN.EDU.SEU.多线程;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 打印多线程的相关信息
 * java并发编程的艺术    p84
 * Created by LCN on 2016/4/22.
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo : threadInfos){
            System.out.println(threadInfo.getThreadId() + " " + threadInfo.getThreadName());
        }
    }
}
