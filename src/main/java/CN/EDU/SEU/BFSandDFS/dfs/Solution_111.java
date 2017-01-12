package CN.EDU.SEU.BFSandDFS.dfs;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + depth(root);
    }

    int depth(TreeNode t) {
        if (t == null)
            return Integer.MAX_VALUE;
        if (t != null && t.left == null && t.right == null)
            return 0;
        return 1 + Math.min(depth(t.left), depth(t.right));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
