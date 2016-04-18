package CN.EDU.SEU.剑指offer;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;
import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组中重复的数字
 * Created by LCN on 2016/4/18.
 */
public class Test51 {
    private static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static List<Integer> duplicate(int[] number) {
        if (number == null || number.length == 1) {
            return null;
        }
        BubbleSort(number);
        boolean state = false;
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < number.length - 1; i++) {
            j = i + 1;
            if (number[i] == number[j]) {
                if (state == false) {
                    state = true;
                    result.add(number[i]);
                }
            }
            state = false;
        }
        return result;
    }

    public static List<Integer> duplicate2(int[] number) {
        if (number == null || number.length == 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (map.containsKey(number[i])) {
                result.add(number[i]);
            }
            map.put(number[i], 0);
        }
        return result;
    }


    public static int duplicate3(int[] number) {
        if (number == null || number.length < 1) {
            return -1;
        }
        for (int i = 0; i < number.length; i++) {
            if (i < 0 || i > number.length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < number.length; i++) {
            while (number[i] != i) {
                if (number[i] == number[number[i]]) {
                    return number[i];
                } else {
                    swap(number, i, number[i]);
                }
            }
        }
        return -1;
    }


    private static void swap(int[] number, int x, int y) {
        int tmp = number[x];
        number[x] = number[y];
        number[y] = tmp;
    }

    @Test
    public void test01() {
        int[] numbers1 = {2, 1, 3, 2, 4, 1, 4, 3, 5};
        List<Integer> result = duplicate(numbers1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    @Test
    public void test02() {
        int[] numbers1 = {2, 1, 3, 2, 4, 1, 4, 3, 3, 5};
        List<Integer> result = duplicate2(numbers1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }


    @Test
    public void test03(){
        int[] number= {2, 1, 3, 2, 4, 1, 4, 3, 3, 5};
        System.out.println(duplicate3(number));
    }




}
