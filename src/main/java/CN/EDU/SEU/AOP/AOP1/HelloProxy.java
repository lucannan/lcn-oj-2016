package CN.EDU.SEU.AOP.AOP1;

/**
 * Created by LCN on 2016-10-22.
 */
public class HelloProxy implements IHello {
    private IHello hello;

    public HelloProxy(IHello hello) {
        this.hello = hello;
    }

    public void sayHello(String name) {
        Logger.logging(Level.DEBUGE, "sayHello method start .");
        hello.sayHello(name);
        Logger.logging(Level.INFO, "sayHello method end!");

    }

    @Override
    public void sayGoogBye(String name) {
        Logger.logging(Level.DEBUGE, "sayGoogBye method start .");
        hello.sayGoogBye(name);
        Logger.logging(Level.INFO, "sayGoogBye method end!");
    }
}