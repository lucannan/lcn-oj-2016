package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * Created by LCN on 2016/4/19.
 */
public class Test15 {

    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if (k < 1 || head == null) {
            return null;
        }

        ListNode pointer = head;
        for (int i = 1; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }

        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }

        return head;
    }

    @Test
    public void test01() {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个
        System.out.println(findKthToTail(head, 10));
    }
}
