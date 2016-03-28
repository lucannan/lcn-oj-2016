package CN.EDU.SEU.程序员面试经典.链表;

/**
 * 编写代码 以给定值x为基准将链表分隔成两部分，
 * 所有小于x的结点排在大于或等于x的结点之前
 * Created by LCN on 2016/3/28.
 */
public class __2_4Partion {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;

            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }


    /**
     * 结点插入到这两个链表的前端
     * @param node
     * @param x
     * @return
     */
    public static LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        while (node != null) {
            LinkedListNode next = node.next;

            if (node.data < x) {
                node.next = beforeStart;
                beforeStart = node;
            } else {
                node.next = afterStart;
                afterStart = node;
            }
        }

        if (beforeStart == null) {
            return afterStart;
        }

        LinkedListNode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }

        beforeStart.next = afterStart;

        return head;
    }
}
