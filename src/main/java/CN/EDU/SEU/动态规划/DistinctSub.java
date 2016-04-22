package CN.EDU.SEU.动态规划;

import org.junit.Test;

/**
 * 给定两个字符串word1和word2,求出最少需要多少个步骤可以将word1转化为word2，
 * 其中每一个操作都被计为一步
 * 1）初始条件：T为空串时，S为任意字符串都能匹配一次，所以dp[i][0]=1
 * S为空字符串，T不为空时，不能匹配，dp[0][j] =0
 * 2)S[i] == T[j]，dp[i][j] = dp[i-1][j-1]+dp[i-1][j].表示当前字符可以保留
 * 也可以抛弃
 * 3）S[i] != T[j]，dp[i][j] = dp[i-1][j-1]
 * 1）插入一个字符
 * 2）删除一个字符
 * 3）替换一个字符
 * Created by LCN on 2016/4/22.
 */
public class DistinctSub {


    public static int distinctSub(String src, String dst) {
        int[][] dp = new int[src.length()][dst.length()];

        for (int i = 0; i < src.length(); i++) {
            for (int j = 0; j < dst.length(); j++) {
                dp[i][j] = 0;
            }
        }

        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        if (srcArr[0] == dstArr[0]) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (srcArr[i] == dstArr[0]) ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (srcArr[i] == dstArr[j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    @Test
    public void test01(){
        String src = "rabbbit";
        String dst = "rabbit";

        System.out.println(distinctSub(src,dst));
    }
}
