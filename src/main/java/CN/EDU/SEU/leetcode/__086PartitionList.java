package CN.EDU.SEU.leetcode;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;

/**
 * Created by LCN on 2016/4/14.
 */
public class __086PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //新建左链表和右链表
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        ListNode p = head;

        while (p != null) {
            if (p.val < x){
                leftTail.next = p;

            }
        }

        return null;
    }
}
