package CN.EDU.SEU.几个常用数据结构;

import jdk.nashorn.internal.ir.IfNode;

import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by LCN on 2016/3/20.
 */
public class Stack<Item> implements Iterable<Item> {
    private int n;
    private Node<Item> first;

    public static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty())
            throw new RuntimeException();
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty())
            throw new RuntimeException();
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new RuntimeException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            s.push(random.nextInt(1000));
        }


        for (Integer a : s) {
            System.out.print(a + " ");
        }
    }
}
