package CN.EDU.SEU.leetcode;

public class Solution_226 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		if (root.left != null && root.right != null) {
			TreeNode tmp = root.left;
			root.left = invertTree(root.right);
			root.right = tmp;
			
		}
		return null;
	}
}
