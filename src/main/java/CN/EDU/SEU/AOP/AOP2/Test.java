package CN.EDU.SEU.AOP.AOP2;

import CN.EDU.SEU.AOP.AOP1.Hello;
import CN.EDU.SEU.AOP.AOP1.IHello;

/**
 * Created by LCN on 2016-10-22.
 */
public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
    }
}
