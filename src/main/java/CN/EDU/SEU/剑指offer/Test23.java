package CN.EDU.SEU.剑指offer;

import CN.EDU.SEU.几个常用数据结构.Queue;
import org.junit.Test;

/**
 * 从上往下打印二叉树
 * Created by LCN on 2016/4/20.
 */
public class Test23 {
    public static void bfs(BinaryTreeNode root) {
        if (root != null) {
            Queue<BinaryTreeNode> queue = new Queue<>();
            queue.enqueue(root);

            BinaryTreeNode currNode;
            while (!queue.isEmpty()) {
                currNode = queue.dequeue();
                System.out.print(currNode.value + " ");
                if (currNode.left != null) {
                    queue.enqueue(currNode.left);
                }
                if (currNode.right != null) {
                    queue.enqueue(currNode.right);
                }
            }
        }
    }

    @Test
    public void test01() {
        // 8
        // / \
        // 6 10
        // / \ / \
        // 5 7 9 11
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;
        bfs(root);
        // 1
        // /
        // 3
        // /
        // 5
        // /
        // 7
        // /
        // 9
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 1;
        root2.left = new BinaryTreeNode();
        root2.left.value = 3;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.value = 5;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        bfs(root2);
        // 0
        // \
        // 2
        // \
        // 4
        // \
        // 6
        // \
        // 8
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.value = 0;
        root3.right = new BinaryTreeNode();
        root3.right.value = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.value = 4;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        bfs(root3);
        // 1
        BinaryTreeNode root4 = new BinaryTreeNode();
        root4.value = 1;
        System.out.println("\n");
        bfs(root4);
        // null
        System.out.println("\n");
        bfs(null);
    }

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }


}
