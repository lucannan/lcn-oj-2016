package CN.EDU.SEU.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode爬楼梯
 * Created by LCN on 2016/4/13.
 */
public class __70ClimbingStairs {

    public static Long solution(Long n, Map<Long, Long> cache) {
        if (n < 1) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        if (n == 2) {
            return 2L;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }

        Long reulst = solution(n - 1, cache) + solution(n - 2, cache);
        cache.put(n, reulst);
        return reulst;
    }

    /**
     * 使用通向公式计算
     * 空间复杂度O(1)
     * 时间复杂度O(log2n)   主要消耗在几个数学表达式上
     *
     * @param n
     */
    public static int fib06(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            double sqrtFive = Math.sqrt(5);
            n++;
            double a = Math.pow((1 + sqrtFive) / 2, n);
            double b = Math.pow((1 - sqrtFive) / 2, n);
            double result = 1 / sqrtFive * (a - b);
            return (int) Math.floor(result);
        }
    }

    public static void main(String[] args) {
        Map<Long, Long> cache = new HashMap<>();
        System.out.println(solution(100L, cache));
    }
}
