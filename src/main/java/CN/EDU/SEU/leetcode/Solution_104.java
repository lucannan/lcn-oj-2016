package CN.EDU.SEU.leetcode;

public class Solution_104 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		// implement using elimiation of next children nodes that are null
		// before recursive call.
		if (root == null)
			return 0;
		else if (root.right != null && root.left != null)
			return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);

		else if (root.right != null)
			return maxDepth(root.right) + 1;
		else /* if (root.left != null) */ return maxDepth(root.left) + 1;

	}
}
