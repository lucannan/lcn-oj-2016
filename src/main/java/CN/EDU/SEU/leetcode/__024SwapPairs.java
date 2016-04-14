package CN.EDU.SEU.leetcode;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;
import org.junit.Test;

/**
 * 交换链表中相邻的两个节点
 * Created by LCN on 2016/4/14.
 */
public class __024SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode zero = newHead;
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode next = null;

        while (pre != null && p != null) {
            next = p.next;
            p.next = pre;
            pre.next = next;
            zero.next = p;
            if (next == null) {
                break;
            } else {
                zero = pre;
                pre = next;
                p = pre.next;
            }
        }
        return newHead.next;
    }

    @Test
    public void test01(){
        Integer[] array = {1,2,3,4,5,6};
        ListNode head = new ListNode().arrayToList(array);
        head = swapPairs(head);
        ListNode.printList(head);

    }
}
