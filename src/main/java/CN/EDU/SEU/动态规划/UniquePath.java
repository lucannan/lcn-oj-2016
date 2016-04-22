package CN.EDU.SEU.动态规划;

import org.junit.Test;

/**
 * 求矩阵中从左上角到右下角的路径数目
 * 求矩阵中左上角到右下角最小路径和
 * Created by LCN on 2016/4/22.
 */
public class UniquePath {

    public static int uniquePath(int m, int n, int first, int second) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        dp[0][0] =1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    if (i == first && j == second) {
                        dp[i][j] = 0;
                    } else {
                        if (i == 0)
                            dp[i][j] = dp[i][j - 1];
                        else if (j == 0)
                            dp[i][j] = dp[i - 1][j];
                        else
                            dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    @Test
    public void test01(){
        System.out.println(uniquePath(3,7,2,3));
    }
}
