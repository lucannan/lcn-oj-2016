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
        if (cache.get(n) !=null){
            return cache.get(n);
        }

        Long reulst = solution(n - 1,cache) + solution(n - 2,cache);
        cache.put(n,reulst);
        return reulst;
    }

    public static void main(String[] args) {
        Map<Long,Long> cache = new HashMap<>();
        System.out.println(solution(100L,cache));
    }
}
