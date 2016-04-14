package CN.EDU.SEU.极客学院名企面试.链表操作;

import org.junit.Test;

/**
 * Created by LCN on 2016/4/14.
 */
public class __061RoatateLIst {

    public int lengthOfList(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        return n;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        } else {
            int n = lengthOfList(head);
            if (k >= n) {
                k = k % n;
            }
            if (k == 0) {
                return head;
            }
            ListNode pre = head;
            int index = 1;
            while (index < n - k) {
                pre = pre.next;
                index++;
            }

            ListNode newHead = pre.next;
            ListNode last = newHead;

            while (last.next != null) {
                last = last.next;
            }

            pre.next = null;
            last.next = head;
            return newHead;
        }
    }

    @Test
    public void test() {
        Integer[] array1 = {1, 2, 3, 4, 5};
        ListNode<Integer> head = new ListNode<Integer>().arrayToList(array1);
        head = rotateRight(head, 3);
        ListNode.printList(head);
    }
}
