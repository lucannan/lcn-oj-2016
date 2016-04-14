package CN.EDU.SEU.leetcode;

import CN.EDU.SEU.极客学院名企面试.链表操作.ListNode;
import org.junit.Test;

/**
 * Created by LCN on 2016/4/14.
 */
public class __086PartitionList {


    //时间复杂度为O(N)
    //空间复杂度为O(1)
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
            if (p.val < x) {
                leftTail.next = p;
                leftTail = p;
            } else {
                rightTail.next = p;
                rightTail = p;
            }
            p = p.next;
        }
        p = leftTail;
        p.next = rightHead.next;

        rightTail.next = null;
        return leftHead.next;
    }

    @Test
    public void test(){
       int [] array = {1,4,3,2,5,2};
        int x = 3;
        ListNode head = new ListNode().arrayToList(array);
        head = partition(head,x);
        ListNode.printList(head);
    }
}
