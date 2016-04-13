package CN.EDU.SEU.极客学院名企面试;

/**
 * Created by LCN on 2016/4/13.
 */

/**
 * 递归调用构造函数，并捕获异常
 */
public class SumExceptionConstructor {
    public static int n;
    public static int[] array;

    public SumExceptionConstructor(int i) {
        try {
            array[i] = array[i - 1] + i;
            new SumExceptionConstructor(i + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(array[n]);
            return;
        }
    }
}
