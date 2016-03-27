package CN.EDU.SEU.JVM;

/**
 * Created by LCN on 2016/3/19.
 */
public class Test {

    static {
        int i = 1;
        i = 0;
        System.out.println(i);
    }



    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("CN.EDU.SEU.JVM.Test");
    }
}
