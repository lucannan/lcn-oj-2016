package CN.EDU.SEU;

import java.util.*;

/**
 * Created by LCN on 2016/3/22.
 */
public class App {

    public static void App() {
        System.out.println("hello world");
        new App().test();
    }

    public void test(){

    }

    public static void main(String[] args) {
        App();
    }
}

abstract class Test {
   abstract void test();
}