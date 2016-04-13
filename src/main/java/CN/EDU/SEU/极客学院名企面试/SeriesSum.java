package CN.EDU.SEU.极客学院名企面试;

/**
 * 输入一个正整数s,打印出所有和为s的连续正整数序列，至少包含两个数字
 * Created by LCN on 2016/4/13.
 */
public class SeriesSum {
    public static void printResult(int start, int end) {
        for (int k = start; k <= end; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void addSum(int s) {
        int start = 1, end = 2;
        int sum = start + end;
        int half = (s + 1) / 2;
        while (start < half) {
            if (sum == s) {
                printResult(start, end);
                sum = sum - start;
                start++;
                end++;
                sum += end;
            } else if (sum < s) {
                end++;
                sum += end;
            } else {
                sum = sum - start;
                start++;
            }
        }
    }


    public static void main(String[] args) {
        addSum(1000);
    }
}
