package CN.EDU.SEU.AOP.AOP3;

import CN.EDU.SEU.AOP.AOP1.Hello;
import CN.EDU.SEU.AOP.AOP1.IHello;

/**
 * Created by LCN on 2016-10-22.
 */
public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello2().bind(new Hello(), new LoggerOperation());
        hello.sayGoogBye("lcn ");
        hello.sayHello("lcn ");
    }
}
