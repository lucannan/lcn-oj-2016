package CN.EDU.SEU.AOP.AOP1;

/**
 * Created by LCN on 2016-10-22.
 */
public class Hello implements IHello {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoogBye(String name) {
        System.out.println(name + "goodbye");

    }
}
