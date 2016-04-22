package CN.EDU.SEU.动态规划;

import org.junit.Test;

/**
 * Created by LCN on 2016/4/20.
 */
public class DecodeNum {

    public static int decodeNum(String str) {
        if (str == null || str.length() < 1) {
            throw new RuntimeException("invalid input");
        }
        if (str.length() == 1) {
            return 1;
        }

        char[] strArr = str.toCharArray();
        int[] dp = new int[str.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        if (strArr[0] == '1' || (strArr[0] == '2' && strArr[1] <= '6')) {
            dp[1] = 2;
        }

        for (int i = 2; i < strArr.length; i++) {
            if (strArr[i] >= '0' && strArr[i] <= '9') {//判断是否是合法的输入
                dp[i] = dp[i - 1];
            } else {
                return 0;
            }
            int tmp = strArr[i - 1] - '0';
            tmp = tmp * 10 + strArr[i] - '0';

            if (strArr[i - 1] != '0' && tmp <= 26) {
                //dp[i]
                dp[i] = dp[i] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }


    @Test
    public void test01(){
        String str = "123172512323534642334242536445324" ;
        System.out.println(decodeNum(str));
    }

}
