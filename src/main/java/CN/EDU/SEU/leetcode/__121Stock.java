package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/5/18.
 */
public class __121Stock {

    //从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，
    // 并计算以当天价格出售的收益，作为可能的最大收益，整个遍历过程中，
    // 出现过的最大收益就是所求
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        System.out.println(maxProfit(prices));
    }

}
