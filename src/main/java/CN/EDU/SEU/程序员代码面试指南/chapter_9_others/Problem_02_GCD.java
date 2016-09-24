package CN.EDU.SEU.程序员代码面试指南.chapter_9_others;

public class Problem_02_GCD {

    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static void main(String[] args) {

        System.out.println(gcd(18, 27));

    }

}
