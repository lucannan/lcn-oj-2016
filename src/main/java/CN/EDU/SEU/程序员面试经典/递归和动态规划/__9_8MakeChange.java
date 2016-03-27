package CN.EDU.SEU.程序员面试经典.递归和动态规划;

/**
 * 给定数量不定的硬币，币值为25分，10分，5分和1分，编写代码计算n分有多少种表示方法
 * Created by LCN on 2016/3/27.
 */
public class __9_8MakeChange {

    public static int makeChanger(int n, int denom) {
        int next_domn = 0;
        switch (denom) {
            case 25:
                next_domn = 10;
                break;
            case 10:
                next_domn = 5;
                break;
            case 5:
                next_domn = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChanger(n - i * denom, next_domn);
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(makeChanger(100,25));
    }
}
