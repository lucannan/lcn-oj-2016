package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/5/18.
 */
//用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
// 交易次数不限，但一次只能交易一支股票，也就是说手上最多只能持有一支股票，
// 求最大收益
public class __122Stock {
    //贪心法。从前向后遍历数组，只要当天的价格高于前一天的价格，就算入收益。
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }

        return maxProfit;
    }
}
