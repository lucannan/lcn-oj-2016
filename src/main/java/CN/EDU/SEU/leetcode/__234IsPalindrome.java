package CN.EDU.SEU.leetcode;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;
import org.junit.Test;

/**
 * 回文链表
 * Created by LCN on 2016/4/14.
 */
public class __234IsPalindrome {

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


    //时间复杂度O(N)   空间复杂度O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int n = lengthOfList(head);
        int half = n / 2;
        ListNode leftEnd = head;
        for (int i = 0; i < half - 1; i++) {
            leftEnd = leftEnd.next;
        }
        ListNode rightStart = leftEnd.next;
        if (n % 2 != 0) {
            rightStart = rightStart.next;
        }

        rightStart = reverseList(rightStart);

        ListNode leftStart = head;
        for (int i = 1; i <= half; i++) {
            if (leftStart.val != rightStart.val) {
                return false;
            }

            leftStart = leftStart.next;
            rightStart = rightStart.next;
        }

        return true;
    }

    @Test
    public void test(){
        int[] array1={0,0};
        ListNode head=new ListNode().arrayToList(array1);
        System.out.println(isPalindrome(head));
    }
}
