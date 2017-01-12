package CN.EDU.SEU.BFSandDFS.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
}
