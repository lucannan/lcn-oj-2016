package CN.EDU.SEU.动态代理;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), Helloworld.class);
//        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
//        final InvocationHandler ih = new MyInvocationHandler(new HelloworldImpl());
//        Helloworld helloWorld = (Helloworld) cons.newInstance(ih);
//        helloWorld.sayHello();


        Helloworld Helloworld=(Helloworld)Proxy.
                 newProxyInstance(JDKProxyTest.class.getClassLoader(),
                        new Class<?>[]{Helloworld.class},
                        new MyInvocationHandler(new HelloworldImpl()));
        Helloworld.sayHello();

    }
}
