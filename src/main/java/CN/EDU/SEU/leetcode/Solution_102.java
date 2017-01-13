package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_102 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void helper(TreeNode root, List<List<Integer>> rst, int level) {
		if (root == null) {
			return;
		}
		if (rst.size() - 1 < level) {
			List<Integer> sol = new ArrayList<Integer>();
			sol.add(root.val);
			rst.add(new ArrayList<Integer>(sol));
			helper(root.left, rst, level + 1);
			helper(root.right, rst, level + 1);
		} else {
			rst.get(level).add(root.val);
			helper(root.left, rst, level + 1);
			helper(root.right, rst, level + 1);
		}
		return;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		helper(root, rst, 0);
		return rst;
	}
}
