package CN.EDU.SEU.JVM;

/**
 * Created by LCN on 2016/3/18.
 */
public class VolatileStopThread extends Thread {
    private boolean stop = false;

    public void stopMe() {
        stop = true;
    }

    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("stop thread");
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileStopThread t = new VolatileStopThread();
        t.start();
        Thread.sleep(1000);

        t.stopMe();

        Thread.sleep(1000);
    }
}
