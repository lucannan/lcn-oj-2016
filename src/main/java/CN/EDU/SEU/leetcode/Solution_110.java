package CN.EDU.SEU.leetcode;

public class Solution_110 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return getHeight(root) != -1;
	}

	public int getHeight(TreeNode root) 
    {
        if(root == null) 
        {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1)
        {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1)
        {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1)
        return -1;
        else
        return (Math.max(leftHeight, rightHeight)) + 1;
    }
}
