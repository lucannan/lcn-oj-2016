package CN.EDU.SEU.极客学院名企面试.二分法;

import org.junit.Test;

/**
 * 实现一个自己的求对数函数
 * Created by LCN on 2016/4/14.
 */
public class Mylog {

    public static final double d = 0.000001;

    //logab
    public double logCommon(double a, double b) {
        return Math.log(b) / Math.log(a);
    }

    //辅助函数进行四舍五入
    public double isLog(double a, double mid, double b) {
        long c = Math.round(mid);
        if (Math.pow(a, c) == b) {
            return c;
        } else {
            return mid;
        }
    }


    //时间复杂度  与精度有关  至少是logN * logN
    //空间复杂度   O(1)
    public double logBinary(double a, double b) {
        if (b == 1) {
            return 0;
        }
        double start = 0;
        double end = b;
        double mid;
        while (true) {
            mid = (end + start) / 2;
            double pow = Math.pow(a, mid);
            if (Math.abs(pow - b) <= d) {
                return isLog(a, mid, b);
            } else if (pow < b) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }

    /**
     * 牛顿法求对数函数
     *
     * @param a
     * @param b
     * @param init 牛顿法的初始值
     * @return
     */
    public double myLogNewTon(double a, double b, double init) {
        if (b == 1) {
            return 0;
        } else {
            double lnA = Math.log(a);
            double x = init;
            double xNext = 0; //定义切线与x轴的交点
            while (true) {
                double pow = Math.pow(a, x);
                xNext = x - (pow - b) / (pow * lnA);

                if (Math.abs(Math.pow(a, xNext) - b) <= d) {
                    return isLog(a, xNext, b);
                }

                x = xNext;
            }
        }
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long startNano = System.nanoTime();
        System.out.println(Math.log(1));  //ln
        System.out.println(Math.log10(1)); //log10
        System.out.println(Math.log1p(10));  //ln(1+x)
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        long endNano = System.nanoTime();
        System.out.println(endNano - startNano);
    }

    @Test
    public void test01() {
        System.out.println(logBinary(10, 100));
        System.out.println(myLogNewTon(10, 100, 9));
    }
}
