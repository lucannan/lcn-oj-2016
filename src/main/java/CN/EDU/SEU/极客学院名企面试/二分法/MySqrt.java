package CN.EDU.SEU.极客学院名企面试.二分法;

import org.junit.Test;

/**
 * 二分法求根号
 * 牛顿法求根号
 * Created by LCN on 2016/4/13.
 */
public class MySqrt {
    public static final double d = 0.000001;

    //辅助函数  四舍五入
    public double isSquart(double x, double mid) {
        long a = Math.round(mid);
        if (a * a == x) {
            return a;
        } else {
            return mid;
        }
    }

    //二分法求根号
    public double sqrtBinary(double x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double start = 0;
        double end = x;
        double mid;

        while (true) {
            mid = (start + end) / 2;
            if (mid == x / mid || Math.abs(mid - x / mid) <= d) {
                return isSquart(x, mid);
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }

    //牛顿法求根号
    public double sqrtNewton(double y0) {
        double x = y0;
        double nextX;
        while (true) {  //不断做切线，求得切线和x轴的焦点
            nextX = x - (x * x - y0) / (2 * x);
            if (Math.abs(nextX - y0 / nextX) <= d) {
                return isSquart(y0, nextX);
            }
            x = nextX;
        }
    }

    @Test
    public void test01() {
        System.out.println(sqrtBinary(3));
        System.out.println(sqrtBinary(4));
        System.out.println(sqrtBinary(5));

        System.out.println(sqrtNewton(98));
    }
}
