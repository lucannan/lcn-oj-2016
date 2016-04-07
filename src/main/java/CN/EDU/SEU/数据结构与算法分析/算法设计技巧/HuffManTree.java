package CN.EDU.SEU.数据结构与算法分析.算法设计技巧;

import java.util.*;

/**
 * huffman编码树实现
 * Created by LCN on 2016/4/7.
 */
public class HuffManTree {
    public static class Node<E> {
        E data;
        int weight;
        Node leftChild;
        Node rightChild;

        public Node(E data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }

    //将指定数组的i和j索引处的元素进行交换
    public static void swap(List<Node> nodes, int i, int j) {
        Node temp = null;
        temp = nodes.get(i);
        nodes.set(i, nodes.get(i));
        nodes.set(j, temp);
    }

    //实现快速排序算法,对结点进行排序，从大到小的排序
    public static int divison(List<Node> nodes, int left, int right) {
        Node base = nodes.get(left);
        while (left < right) {
            //向右开始遍历，知道找到比base.weight 小的
            while (left < right && nodes.get(right).weight <= base.weight)
                right--;
            nodes.set(left, nodes.get(right));

            while (left < right && nodes.get(left).weight >= base.weight)
                left++;

            nodes.set(right, nodes.get(left));
        }

        nodes.set(left, base);
        return left;
    }


    public static void subSort2(List<Node> nodes, int left, int right) {
        if (left < right) {
            int base = divison(nodes, left, right);
            subSort2(nodes, left, base - 1);
            subSort2(nodes, base + 1, right);
        }
    }


    public static void quickSort2(List<Node> nodes) {
        subSort2(nodes, 0, nodes.size() - 1);
    }


    public static Node createTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            quickSort2(nodes);
            //获取权值最小的两个结点
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);

            Node parent = new Node(null, left.weight + right.weight);
            parent.leftChild = left;
            parent.rightChild = right;

            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //根据树来重建链表
    public static List<Node> breadthFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();

            if (p.leftChild != null) {
                queue.offer(p.leftChild);
            }
            if (p.rightChild != null) {
                queue.offer(p.rightChild);
            }
        }
        return list;
    }

    //实现快速排序算法,对结点进行排序，从大到小的排序
    public static void subSort(List<Node> nodes, int start, int end) {
        if (start < end) {
            Node base = nodes.get(start);
            int i = start;
            int j = end; //左后一个
            while (true) {
                //找到大于分界值的元素的索引，或i已经到了end处
                while (i < end && nodes.get(++i).weight >= base.weight) ;
                //找到小于分界值的元素的索引，或j已经到了start处
                while (j > start && nodes.get(--j).weight <= base.weight) ;
                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
            }
            swap(nodes, start, j);
            //左序列
            subSort(nodes, start, j - 1);
            //右序列
            subSort(nodes, j + 1, end);
        }
    }

    public static void quickSort(List<Node> nodes) {
        subSort(nodes, 0, nodes.size() - 1);
    }


    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("A", 40));
        nodes.add(new Node("B", 8));
        nodes.add(new Node("C", 10));
        nodes.add(new Node("D", 30));
        nodes.add(new Node("E", 10));
        nodes.add(new Node("F", 2));
        Node root = createTree(nodes);
        System.out.println(breadthFirst(root));
    }
}
