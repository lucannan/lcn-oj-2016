package CN.EDU.SEU.BFSandDFS.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        List<TreeNode> candidates = new LinkedList<TreeNode>();
        candidates.add(root);
        while (!candidates.isEmpty()) {
            List<TreeNode> temp = new LinkedList<TreeNode>();
            res.add(candidates.get(0).val);
            for (TreeNode curr : candidates) {
                if (curr.right != null)
                    temp.add(curr.right);
                if (curr.left != null)
                    temp.add(curr.left);
            }
            candidates = temp;
        }
        return res;
    }
}
