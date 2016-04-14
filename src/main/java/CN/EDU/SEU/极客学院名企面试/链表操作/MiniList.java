package CN.EDU.SEU.极客学院名企面试.链表操作;

import org.junit.Test;

import java.util.Comparator;

/**
 * 链表的一些简单的操作
 * Created by LCN on 2016/4/14.
 */
public class MiniList<T> {
    private ListNode<T> head = new ListNode<>(null, null);
    public Comparator<T> comparator;

    public int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            Comparable<T> c = (Comparable<T>) a;
            return c.compareTo(b);
        }
    }

    public void arrayToList(T[] array) {
        ListNode<T> p = head;
        for (T t : array) {
            ListNode<T> node = new ListNode<>(t, null);
            p.next = node;
            p = node;
        }
    }


    public void printList() {
        ListNode<T> p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void insert(int index, T value) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }

        ListNode<T> node = new ListNode<>(value, null);
        node.next = p.next;
        p.next = node;
    }


    public T remove(int index) {
        ListNode<T> pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode<T> p = pre.next;
        pre.next = p.next;
        return p.val;
    }

    public T get(int index) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }


    public void set(int index, T value) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        p.val = value;
    }

    //时间复杂度为O(N)  空间复杂度为O(1)
    public T getMax() {
        if (head.next == null) {
            return null;
        }

        ListNode<T> p = head.next;
        T max = p.val;
        p = p.next;
        while (p != null) {
            if (compare(p.val, max) > 0) {
                max = p.val;
            }
            p = p.next;
        }
        return max;
    }

    @Test
    public void testMiniList() {
        MiniList<Integer> list = new MiniList<>();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        list.arrayToList(array);
        list.printList();
    }
}
