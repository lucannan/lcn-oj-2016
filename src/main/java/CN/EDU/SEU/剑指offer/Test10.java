package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 二进制中1的个数
 * Created by LCN on 2016/4/19.
 */
public class Test10 {
    public static int numberOfOne(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }


    public static int numberOfOne2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n - 1) & n;
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(numberOfOne(0xc0000000));
        System.out.println(Integer.toBinaryString(0xc0000000));
    }
}
