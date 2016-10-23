package CN.EDU.SEU.AOP.AOP1;

/**
 * Created by LCN on 2016-10-22.
 */
public class Test {
    public static void main(String[] args) {
        IHello hello = new HelloProxy(new Hello());
        hello.sayHello("Doublej");
    }
}
