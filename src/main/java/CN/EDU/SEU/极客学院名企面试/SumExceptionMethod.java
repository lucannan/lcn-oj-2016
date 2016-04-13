package CN.EDU.SEU.极客学院名企面试;

/**
 * 加了限制条件的加法
 * 不能使用循环
 * 不能使用判断语句
 * 不能使用乘除
 * Created by LCN on 2016/4/13.
 */
public class SumExceptionMethod {
    private int n;
    private int[] array;

    public SumExceptionMethod() {
        super();
    }

    public SumExceptionMethod(int n) {
        super();
        this.n = n;
        array = new int[n + 1];
    }

    public int sumMethod(int i) {
        try {
            array[i] = array[i - 1] + i;
            int k = sumMethod(i + 1);
            return k;
        } catch (ArrayIndexOutOfBoundsException e) {
            return array[n];
        }
    }


    public static void main(String[] args) {
        System.out.println(new SumExceptionMethod(100).sumMethod(1));
    }
}
