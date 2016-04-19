package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 数值的整数次方
 * Created by LCN on 2016/4/19.
 */
public class Test11 {

    public static double power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            throw new RuntimeException("invalid data");
        }

        if (exponent == 0) {
            return 1;
        }

        long exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }

        double result = powerWithUnsignedExponent(base,exponent);
        if (exponent < 0){
            result = 1/ result;
        }
        return result;
    }


    public static double powerWithUnsignedExponent(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result = result * result;

        if (exponent % 2 != 0) {
            result *= base;
        }
        return result;
    }

    @Test
    public void test01(){
        System.out.println(power(3,4));
    }
}
