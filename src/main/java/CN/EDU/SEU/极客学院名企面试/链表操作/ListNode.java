package CN.EDU.SEU.极客学院名企面试.链表操作;

/**
 * 最开始的一个结点保存数据
 * Created by LCN on 2016/4/14.
 */
public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }


    @Override
    public String toString() {
        return "ListNode [val=" + val + "]";
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public ListNode arrayToList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int value : array) {
            p.next = new ListNode(value);
            p = p.next;
        }
        return head.next;
    }
}
