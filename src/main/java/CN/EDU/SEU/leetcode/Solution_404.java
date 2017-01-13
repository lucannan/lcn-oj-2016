package CN.EDU.SEU.leetcode;

public class Solution_404 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		// Check the left node is a leaf or not. If yes, add it to sum and
		// return the sum
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}

		sum += sumOfLeftLeaves(root.left);
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}
}
