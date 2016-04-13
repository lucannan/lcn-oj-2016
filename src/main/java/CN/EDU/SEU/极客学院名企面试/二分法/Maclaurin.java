package CN.EDU.SEU.极客学院名企面试.二分法;

import org.junit.Test;

/**
 * 计算自然对数e
 * Created by LCN on 2016/4/13.
 */
public class Maclaurin {

    //计算自然对数e
    public double getE(double n) {
        double a = 1;
        double e = a;

        for (double i = 1; i < n; i++) {
            a /= i;
            e += a;
        }
        return e;
    }

    @Test
    public void test01(){
        double e = getE(100);
        System.out.println(e);
        System.out.println(Math.E);
    }
}
