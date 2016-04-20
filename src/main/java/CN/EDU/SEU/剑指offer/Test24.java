package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 二叉搜索树的后序遍历序列
 * Created by LCN on 2016/4/20.
 */
public class Test24 {

    public static boolean dfs(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return dfs(sequence, 0, sequence.length - 1);
    }


    public static boolean dfs(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }

        int right = index;

        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }
        if (index != end - 1) {
            return false;
        }

        index = right;

        return dfs(sequence, start, index - 1) && dfs(sequence, index, end - 1);
    }


    @Test
    public void test01() {
        // 10
        // / \
        // 6 14
        // /\ /\
        // 4 8 12 16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + dfs(data));
        // 5
        // / \
        // 4 7
        // /
        // 6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + dfs(data2));
        // 5
        // /
        // 4
        // /
        // 3
        // /
        // 2
        // /
        // 1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + dfs(data3));
        // 1
        // \
        // 2
        // \
        // 3
        // \
        // 4
        // \
        // 5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + dfs(data4));
        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + dfs(data5));
        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + dfs(data6));
        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + dfs(data7));

    }


}
