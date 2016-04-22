package CN.EDU.SEU.动态规划;

import org.junit.Test;

/**
 * 从左上角到右下角，寻找代价最小的路径
 * Created by LCN on 2016/4/22.
 */
public class MinPathSum {

    public int minPathSum(int[][] data) {
        int[][] dp = new int[data.length][data[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = data[0][0];
        for (int i = 1; i < data.length; i++) {
            dp[i][0] = dp[i - 1][0] + data[i][0];
        }

        for (int i = 1; i < data[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + data[0][i];
        }


        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[0].length; j++) {
                int tmp = Math.min(data[i][j] + dp[i][j - 1], data[i][j] + dp[i - 1][j]);
                dp[i][j] = Math.min(dp[i][j], tmp);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    @Test
    public void test01() {
        int[][] data = {{2, 4, 3, 7}, {5, 3, 2, 1}, {4, 8, 6, 2}};
        System.out.println(minPathSum(data));
    }
}
