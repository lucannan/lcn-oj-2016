package CN.EDU.SEU.几个常用数据结构;


import java.util.Iterator;
import java.util.Random;

/**
 * Created by LCN on 2016/3/20.
 */
public class Queue<Item> implements Iterable<Item> {
    private int n;    //number of element on queue

    private Node<Item> first;   //beginning of the queue
    private Node<Item> last;    //end of the queue


    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty())
            return null;
        else
            return first.item;
    }


    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else
            oldlast.next = last;
        n++;
    }


    public Item dequeue() {
        if (isEmpty())
            return null;
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
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
        Queue<Integer> queue = new Queue<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            queue.enqueue(random.nextInt(1000));
        }

        for (Integer a : queue) {
            System.out.print(a + " ");
        }
    }

}
