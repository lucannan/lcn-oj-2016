package CN.EDU.SEU.剑指offer;

/**
 * 打印1到最大的n位数
 * Created by LCN on 2016/4/19.
 */
public class Test12 {
    public static void printOneToNthDigits(int n) {
        if (n <1) {
            throw new RuntimeException("invalid data");
        }

        int[] arr = new int[n];

    }

//    public static void printOneToNthDigits(int n, int[] arr) {
//        // 说明所有的数据排列选择已经处理完了
//        if (n >= arr.length) {
//            // 可以输入数组的值
//            printArray(arr);
//        } else {
//            // 对
//            for (int i = 0; i <= 9; i++) {
//                arr[n] = i;
//                printOneToNthDigits(n + 1, arr);
//            }
//        }
//    }
}
