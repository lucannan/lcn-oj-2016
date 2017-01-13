package CN.EDU.SEU.leetcode;

public class Solution_112 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return helper(root, sum, 0);
	}

	public boolean helper(TreeNode root, int sum, int add) {
		
		if (root.left != null && root.right != null) {
			return helper(root.left,sum,add + root.val) || helper(root.right,sum,add + root.val);
		} else if (root.left != null) {
			return helper(root.left,sum,add + root.val);
		} else if (root.right != null) {
			return helper(root.right,sum,add + root.val);
		} else {
			return add + root.val == sum ? true : false;
		}

	}
}
