package CN.EDU.SEU.数据结构与算法分析;

import java.util.Stack;

/**
 * Created by LCN on 2016/3/21.
 */
public class ExpTree {
        /**表达式树的构建*/
    public static TNode<Character> buildExpTree(String postfixExp) {
        char c;
        TNode<Character> newNode, newLeft, newRight;
        Stack<TNode<Character>> s = new Stack<TNode<Character>>();
        int i = 0, len = postfixExp.length();

        while(i != len) {
            while(postfixExp.charAt(i) == ' ' || postfixExp.charAt(i) == '\t')
                i++;

            if(i == len)
                break;
            c = postfixExp.charAt(i);
            i++;

            if(c == '+' || c == '-' || c == '*' || c == '/') {
                newRight = s.pop();
                newLeft = s.pop();

                newNode = new TNode<Character>(c, newLeft, newRight);
                s.push(newNode);
            } else {
                newNode = new TNode<Character>(c);
                s.push(newNode);
            }
        }

        if(! s.isEmpty())
            return s.pop();
        else
            return null;
    }

    /**中序输出*/
    public static <T> void inorderOutput(TNode<T> t) {
        if (t != null) {
            inorderOutput(t.getLeft());
            System.out.print(t.getKey() + " ");
            inorderOutput(t.getRight());
        }
    }

    public static void main(String[] args) {
        String exp = "abc*+";
        String exp2 = "abc*+de*f+g*+";
        TNode<Character> root = ExpTree.buildExpTree(exp);
        ExpTree.inorderOutput(root); // a + b * c
        System.out.println("============================");
        TNode<Character> root2 = ExpTree.buildExpTree(exp2);
        ExpTree.inorderOutput(root2);
    }

}

 class TNode<T> {
    private T key;
    private TNode<T> left, right;

    public TNode(T key) {
        this(key, null, null);
    }

    public TNode(T key, TNode <T>left, TNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public TNode<T> getLeft() {
        return left;
    }

    public void setLeft(TNode<T> left) {
        this.left = left;
    }

    public TNode<T> getRight() {
        return right;
    }

    public void setRight(TNode<T> right) {
        this.right = right;
    }
}
