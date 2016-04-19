package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 合并两个排序的链表
 * Created by LCN on 2016/4/19.
 */
public class Test17 {
    public static class ListNode {
        int value;
        ListNode next;
    }


    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }
        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }
        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;
        // 当两个链表都不为空就进行合并操作
        while (head1 != null && head2 != null) {
            // 下面的操作合并较小的元素
            if (head1.value < head2.value) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }
            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }
            // 下面的两个if有且只一个if会内的内容会执行
            // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            pointer.next = head1;
        }
            // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            pointer.next = head2;
        }
        // 返回处理结果
        return root.next;
    }


    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }
        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }
        // 记录两个链表中头部较小的结点
        ListNode tmp = head1;
        if (tmp.value < head2.value) {
        // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = merge2(head1.next, head2);
        } else {
        // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }
        // 返回处理结果
        return tmp;
    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    @Test
    public void test01(){
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
        ListNode head2 = new ListNode();
        head2.value = 1;
        head2.next = new ListNode();
        head2.next.value = 3;
        head2.next.next = new ListNode();
        head2.next.next.value = 5;
        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;
        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;
// head = merge(head, head2);
        head = merge2(head, head2);
        printList(head);
    }
}
