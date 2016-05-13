package CN.EDU.SEU.数据结构与算法分析;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * B树的算法实现
 * Created by LCN on 2016/5/13.
 */

public class BTree<E extends Comparable<E>> {
    private BTNode root = null;
    private int t;
    private final int fullNum;

    public BTree(int t) {
        this.t = t;
        fullNum = 2 * t - 1;
    }

    private final BTNode NullBTNode = new BTNode();

    private class BTNode {
        private int number = 0;
        private List<E> values = new ArrayList<E>();
        private List<BTNode> children = new ArrayList<BTNode>();
        private boolean isLeaf = false;

        E getKey(int i) {
            return values.get(i);
        }

        BTNode getChildren(int i) {
            return children.get(i);
        }

        void AddKey(int i, E element) {
            values.add(i, element);
        }

        void removeKey(int i) {
            values.remove(i);
        }

        void AddChildren(int i, BTNode c) {
            children.add(i, c);
        }

        void removeChildren(int i) {
            children.remove(i);
        }

        boolean isFull() {
            if (number == fullNum)
                return true;
            return false;
        }

        int getSize() {
            return values.size();
        }

        boolean isNull() {
            return (this == NullBTNode);
        }

        @Override
        public String toString() {
            if (number == 0)
                return "NullNode";

            StringBuilder sb = new StringBuilder();
            sb.append("[N: " + number + "] [values: ");
            for (E e : values) {
                sb.append(e + ", ");
            }
            sb.append(" ] [ children: ");
            for (BTNode bNode : children) {
                if (bNode == NullBTNode)
                    sb.append(bNode + ", ");
                else
                    sb.append("NotNullNode" + ", ");
            }
            sb.append("] [childrenSize: " + children.size());
            sb.append("] [ isLeaf: " + isLeaf);
            sb.append("]");
            return sb.toString();
        }
    }

    // Generate the root node
    private void constructRoot(E elem) {
        root = new BTNode();
        root.number = 1;
        root.AddKey(0, elem);
        root.isLeaf = false;
    }

    private void addElemToNode(BTNode node, E element, int i) {
        node.AddKey(i, element);
        node.number++;
        node.AddChildren(i, NullBTNode);
    }

    public void insertElem(E elem) {
        if (root == null) {
            // The first node
            constructRoot(elem);
            root.isLeaf = true;
            root.AddChildren(0, NullBTNode);
            root.AddChildren(1, NullBTNode);
            return;
        }

        BTNode curNode = root;

        if (root.isFull()) {
            // Extend the root
            constructRoot(curNode.getKey(t - 1));

            // Get new node
            BTNode newNode = getExtendedNode(curNode);

            // Process old full node
            processFullNode(curNode);

            // Process root
            root.AddChildren(0, curNode);
            root.AddChildren(1, newNode);
            return;
        }

        int i = 0;
        BTNode childNode = null;
        // Find the node to insert
        while (true) {
            while ((i < curNode.getSize())
                    && (elem.compareTo(curNode.getKey(i)) > 0)) {
                i++;
            }

            childNode = curNode.getChildren(i);
            if (childNode.isFull()) {
                // Split the node

                // Add the element to parent
                curNode.number++;
                curNode.AddKey(i, childNode.getKey(t - 1));

                // New node for extension
                BTNode newNode = getExtendedNode(childNode);

                // Process old full node
                processFullNode(childNode);

                // Add the new node for parent reference
                curNode.AddChildren(i + 1, newNode);

                // Down to low layer
                if (elem.compareTo(curNode.getKey(i)) < 0) {
                    curNode = childNode;
                } else {
                    curNode = newNode;
                }
                i = 0;
                continue;
            }

            // Down to child node
            if (!childNode.isNull()) {
                curNode = childNode;
                i = 0;
                continue;
            }

            // Insert the element in current node
            addElemToNode(curNode, elem, i);
            return;
        }

    }

    private BTNode getExtendedNode(BTNode fullNode) {
        BTNode newNode = new BTNode();
        newNode.number = t - 1;
        newNode.isLeaf = fullNode.isLeaf;
        for (int i = 0; i < t; i++) {
            if (i != t - 1) {
                newNode.AddKey(i, fullNode.getKey(t + i));
            }
            newNode.AddChildren(i, fullNode.getChildren(t + i));
        }
        return newNode;
    }

    // Should be called after calling getExtendedNode()
    private void processFullNode(BTNode fullNode) {
        fullNode.number = t - 1;
        for (int i = t - 1; i >= 0; i--) {
            fullNode.removeKey(t + i - 1);
            fullNode.removeChildren(t + i);
        }
    }

    @Override
    public String toString() {
        if (root == null)
            return "NULL";

        StringBuilder sb = new StringBuilder();

        LinkedList<BTNode> queue = new LinkedList<BTNode>();
        queue.push(root);

        BTNode tem = null;
        while ((tem = queue.poll()) != null) {
            for (BTNode node : tem.children) {
                if (!node.isNull())
                    queue.offer(node);
            }
            sb.append(tem.toString() + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BTree<Character> tree = new BTree<Character>(3);
        System.out.println(tree);
        Character[] cL = {'D', 'E', 'F', 'A', 'C', 'B', 'Z', 'H', 'I', 'J'};
        for (int i = 0; i < cL.length; i++) {
            tree.insertElem(cL[i]);
            System.out.println("After insert the: " + cL[i]);
            System.out.println(tree);
        }
    }
}