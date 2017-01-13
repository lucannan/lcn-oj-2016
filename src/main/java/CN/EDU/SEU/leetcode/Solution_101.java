package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_101 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        
        if(!insertNodes(root.left, root.right, q)) return false;
        while(!q.isEmpty()){
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if(!insertNodes(n1.left, n2.right, q) || !insertNodes(n1.right, n2.left, q)) return false;
        }
        
        return true;
    }
    
    public boolean insertNodes(TreeNode n1, TreeNode n2, Queue<TreeNode> q){
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null || n1.val!=n2.val) return false;
        q.add(n1);
        q.add(n2);
        return true;
    }

}
