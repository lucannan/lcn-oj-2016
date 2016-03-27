package CN.EDU.SEU.JVM;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by LCN on 2016/3/18.
 */
public class JavaVMSStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMSStackSOF oom = new JavaVMSStackSOF();
        oom.stackLeak();
    }
}
