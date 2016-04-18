package CN.EDU.SEU.剑指offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 构建乘积数组
 * Created by LCN on 2016/4/18.
 */
public class Test52 {

    public static double[] multiply(double[] data) {
        if (data == null || data.length < 2) {
            return null;
        }
        double[] result = new double[data.length];
        result[0] = 1;
        for (int i = 1; i < data.length; i++) {
            result[i] = result[i - 1] * data[i - 1];
        }

        double tmp = 1;
        for (int i = data.length - 2; i >= 0; i--) {
            tmp *= data[i + 1];
            result[i] = result[i] * tmp;
        }
        return result;
    }


    @Test
    public void test01(){
        double[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(array1))); // double expected[] = {120, 60, 40, 30, 24};

        double[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(multiply(array2))); // double expected[] = {0, 0, 40, 0, 0};
    }


}
