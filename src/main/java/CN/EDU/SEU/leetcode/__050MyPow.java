package CN.EDU.SEU.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个自己的pow函数
 * Created by LCN on 2016/4/13.
 */
@SuppressWarnings("all")
public class __050MyPow {
    public double powLinear(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    //时间复杂度O(N)
    //空间复杂度O(1)
    public double myPowerLinear(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            if (n > 0) {
                return powLinear(x, n);
            } else {
                return 1 / powLinear(x, -n);
            }
        }
    }


    public double logNTime(double x, int n, Map<Integer, Double> cache) {
        if (n == 1) {
            return x;
        } else {
            double subResult = 0;
            if (cache.get(n >>> 1) != null) {
                subResult = cache.get(n >>> 1);
            } else {
                subResult = logNTime(x, n >>> 1, cache);
                cache.put(n / 2, subResult);
            }

            if (n % 2 == 0) {
                return subResult * subResult;
            } else {
                return subResult * subResult * x;
            }
        }
    }


    public double myPowerLinear2(double x, int n) {
        Map<Integer, Double> cache = new HashMap<>();
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            if (n > 0) {
                return logNTime(x, n, cache);
            } else {
                return 1 / logNTime(x, -n, cache);
            }
        }
    }

    @Test
    public void test01() {
        System.out.println(myPowerLinear(3, 5));
        System.out.println(myPowerLinear(-2, 5));
    }

    @Test
    public void test02() {
        System.out.println(myPowerLinear2(3.0855665, 100));
    }
}
