package CN.EDU.SEU.极客学院名企面试.链表操作;

import org.junit.Test;

import java.util.Comparator;

import static javafx.scene.input.KeyCode.T;

/**
 * 链表的一些简单的操作
 * Created by LCN on 2016/4/14.
 */
public class MiniList {
    private ListNode head = new ListNode(0,null);
    public Comparator comparator;

    public int compare(int a, int b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            Comparable c = (Comparable) a;
            return c.compareTo(b);
        }
    }

    public void arrayToList(int[] array) {
        ListNode p = head;
        for (int t : array) {
            ListNode node = new ListNode(t, null);
            p.next = node;
            p = node;
        }
    }


    public void printList() {
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void insert(int index, int value) {
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }

        ListNode node = new ListNode(value, null);
        node.next = p.next;
        p.next = node;
    }


    public int remove(int index) {
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode p = pre.next;
        pre.next = p.next;
        return p.val;
    }

    public int get(int index) {
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }


    public void set(int index, int value) {
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        p.val = value;
    }

    //时间复杂度为O(N)  空间复杂度为O(1)
    public int getMax() {
        if (head.next == null) {
            return Integer.MIN_VALUE;
        }

        ListNode p = head.next;
        int max = p.val;
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
        MiniList list = new MiniList();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        list.arrayToList(array);
        list.printList();
    }
}
