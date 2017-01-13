package CN.EDU.SEU.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_107 {
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
		List<List<Integer>> result = new ArrayList<List<Integer>>();


		for (int i = 0; i < rst.size(); i++) {
			result.add(rst.get(rst.size() - 1 - i)); 
		}

		return result;
	}
}
