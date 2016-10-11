package CN.EDU.SEU.剑指offer;

/**
 * 斐波那契数列
 * Created by LCN on 2016-10-10.
 */
public class Test09 {
    /**
     * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项
     *
     * @param n Fibonacci数的项数
     * @return 第n项的结果
     */
    public static long fibonacci(int n) {
        // 当输入非正整数的时候返回0
        if (n <= 0) {
            return 0;
        }
        // 输入1或者2的时候返回1
        if (n == 1 || n == 2) {
            return 1;
        }
        // 记录前两个（第n-2个）的Fibonacci数的值
        long prePre = 1;
        // 记录前两个（第n-1个）的Fibonacci数的值
        long pre = 1;
        // 记录前两个（第n个）的Fibonacci数的值
        long current = 2;
        // 求解第n个的Fibonacci数的值
        for (int i = 3; i <= n; i++) {
        // 求第i个的Fibonacci数的值
            current = prePre + pre;
        // 更新记录的结果，prePre原先记录第i-2个Fibonacci数的值
        // 现在记录第i-1个Fibonacci数的值
            prePre = pre;
        // 更新记录的结果，pre原先记录第i-1个Fibonacci数的值
        // 现在记录第i个Fibonacci数的值
            pre = current;
        }
        // 返回所求的结果
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }
}
