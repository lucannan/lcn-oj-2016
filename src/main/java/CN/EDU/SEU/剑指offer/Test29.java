package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 数组中出现次数超过一半的数字
 * Created by LCN on 2016/4/20.
 */
public class Test29 {

    public static int moreThanHalfNum(int[] numbers) {

        if (numbers == null || numbers.length < 1) {
            throw new RuntimeException("invalid data");
        }

        int result = numbers[0];
        int count = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (count == 0) {
                result = numbers[i];
                count = 1;
            } else if (result == numbers[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (result == numbers[i]) {
                count++;
            }
        }

        if (count > numbers.length / 2) {
            return result;
        } else {
            throw new RuntimeException("invalid data");
        }
    }

    @Test
    public void test01() {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));
        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));
        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));
        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));
        // 输入空指针
        moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);
    }
}
