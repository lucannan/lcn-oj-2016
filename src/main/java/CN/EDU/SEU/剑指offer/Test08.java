package CN.EDU.SEU.剑指offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 旋转数组中最小的数字
 * Created by LCN on 2016/4/19.
 */
public class Test08 {

    public static void rotateMinArr(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        int min = data[0];
        int index = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                index = i;
                min = data[i];
            }
        }

        if (index == 0) {
            return;
        }

        int[] newArray = new int[data.length];
        int j = 0;
        for (int i = index; i < data.length; i++) {
            newArray[j] = data[i];
            j++;
        }
        for (int i = 0; i < index; i++) {
            newArray[j] = data[i];
            j++;
        }


        for (int i = 0; i < newArray.length; i++) {
            data[i] = newArray[i];
        }
    }

    @Test
    public void test01(){
        int[] array1 = {3, 4, 5, 1, 2};
        rotateMinArr(array1);
        System.out.println(Arrays.toString(array1));


        int[] array2 = {3, 4, 5, 1, 1, 2};
        rotateMinArr(array2);
        System.out.println(Arrays.toString(array2));
    }
}
