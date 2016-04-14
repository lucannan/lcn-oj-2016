package CN.EDU.SEU.leetcode;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;
import org.junit.Test;

/**
 * 给定一个单链表，实现反转和洗牌两个操作
 * 空间复杂度O(1)
 * Created by LCN on 2016/4/14.
 */
@SuppressWarnings("all")
public class __143ReorderList {
    public int lengthOfList(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        head.next = null;
        return pre;
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int n = lengthOfList(head);
        int half = n / 2;
        if (n % 2 != 0) {
            half++;
        }

        ListNode leftEnd = head;
        for (int i = 1; i < half; i++) {
            leftEnd = leftEnd.next;
        }

        ListNode rightStart = leftEnd.next;

        rightStart = reverseList(rightStart);

        leftEnd.next = null;

        ListNode left = head;
        ListNode right = rightStart;

        boolean flag = true;
        ListNode next = null;
        while (right != null) {
            if (flag) {
                next = left.next;
                left.next = right;
                left = next;
            } else {
                next = right.next;
                right.next = left;
                right = next;
            }
            flag = !flag;
        }
    }

    @Test
    public void test(){
        int[] array = {1,2,3,4,5,6,7};
        ListNode head = new ListNode().arrayToList(array);
        reorderList(head);
        ListNode.printList(head);
    }
}
