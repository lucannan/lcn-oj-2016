package CN.EDU.SEU.JVM;

/**
 * Created by LCN on 2016/3/19.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    public final static int test = 456;
    public static int value2 = 789;

}
