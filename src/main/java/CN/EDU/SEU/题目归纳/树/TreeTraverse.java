package CN.EDU.SEU.题目归纳.树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的遍历
 * Created by LCN on 2016-10-8.
 */
@SuppressWarnings("ALL")
public class TreeTraverse {
    private BinaryTreeNode root;

    // 递归中序遍历
    public void inOrder(BinaryTreeNode current) {
        if (current != null) {
            inOrder(current.llink);
            System.out.print(current.info);
            inOrder(current.rlink);
        }
    }

    // 非递归中序遍历
    public void nonRecursiveInOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.empty())) {
            if (current != null) {
                stack.push(current);
                current = current.llink;
            } else {
                current = (BinaryTreeNode) stack.peek();
                stack.pop();
                System.out.print(current.info);
                current = current.rlink;
            }
        }
    }

    // 递归前序遍历
    public void preOrder(BinaryTreeNode current) {
        if (current != null) {
            System.out.print(current.info);
            preOrder(current.llink);
            preOrder(current.rlink);
        }
    }

    // 非递归前序遍历
    public void nonRecursivePreOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                System.out.print(current.info);
                stack.push(current);
                current = current.llink;
            } else {
                current = (BinaryTreeNode) stack.peek();
                stack.pop();
                current = current.rlink;
            }
        }
    }

    // 递归后序遍历
    public void postOrder(BinaryTreeNode current) {
        if (current != null) {
            postOrder(current.llink);
            postOrder(current.rlink);
            System.out.print(current.info);
        }
    }

    // 非递归后序遍历
    public void notRecursivePostOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                current.isFirst = true;
                stack.push(current);
                current = current.llink;
            } else {
                current = stack.peek();
                stack.pop();
                if (current.isFirst) {
                    current.isFirst = false;
                    stack.push(current);
                    current = current.rlink;
                } else {
                    System.out.print(current.info);
                    current = null;
                }
            }
        }
    }

    // 树的层次遍历
    public void bfs() {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!queue.isEmpty())) {
            if (current != null) {
                System.out.print(current.info);
                queue.add(current.llink);
                queue.add(current.rlink);
                current = queue.poll();
            } else {
                current = queue.poll();
            }
        }
    }


    public class BinaryTreeNode {
        private BinaryTreeNode llink = null;
        private BinaryTreeNode rlink = null;
        //结点中的数据
        private int info;
        private boolean isFirst;

        public BinaryTreeNode(int info) {
            this.info = info;
        }
    }


    public void initTree() {
        root = new BinaryTreeNode(1);
        root.llink = new BinaryTreeNode(2);
        root.rlink = new BinaryTreeNode(3);
        root.llink.llink = null;
        root.llink.rlink = new BinaryTreeNode(4);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        TreeTraverse tree = new TreeTraverse();
        tree.initTree();
        tree.preOrder(tree.getRoot());
        // tree.nonRecursivePreOrder();
        // tree.inOrder(tree.getRoot());
        // tree.nonRecursiveInOrder();
        // tree.postOrder(tree.getRoot());
        // tree.notRecursivePostOrder();
//        tree.bfs();
    }
}
