package CN.EDU.SEU.程序员面试经典.递归和动态规划;

/**
 * P221
 * 有一个小孩正在上楼梯，楼梯有n阶台阶，小孩一次一个上1,2,3阶台阶。实现一个方法，计算小孩有多少种
 * 上台阶的方法
 * Created by LCN on 2016/3/27.
 */

public class __9_1CountWays {

    /***
     * 没有使用动态规划
     *
     * @param n
     * @return
     */
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
        }
    }


    /**
     * 使用动态规划
     * @param n
     * @param map   存储已经计算过的节点
     * @return
     */
    public static int countWaysDp(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDp(n - 1, map) + countWaysDp(n - 2, map) + countWaysDp(n - 3, map);
            return map[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
        int [] map = new int[4];
        for (int i = 0; i < map.length;i++){
            map[i] = -1;
        }
        System.out.println(countWaysDp(3,map));
    }
}
