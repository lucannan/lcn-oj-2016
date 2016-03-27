package CN.EDU.SEU.几个常用数据结构;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by LCN on 2016/3/20.
 */
public class Bag<Item> implements Iterable<Item> {
    private int n;// number of elements in bag
    private Node<Item> first;   //begining of bag


    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return n;
    }


    public void add(Item item) {
        Node<Item> oldfist = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfist;
        n++;
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
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }

        public void remove() {

        }
    }


    public boolean hasNext() {
        return false;
    }

    public Item next() {
        return null;
    }


    public static void main(String[] args) {
        Random random = new Random();
        Bag<Integer> bag = new Bag<Integer>();
        for (int i =0;i<1000;i++){
            bag.add(random.nextInt(1000));
        }

        for (Integer a :bag){
            System.out.println(a);
        }

    }

}
