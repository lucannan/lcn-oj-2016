package CN.EDU.SEU.程序员面试经典.链表;

import CN.EDU.SEU.几个常用数据结构.Stack;

/**
 * 编写一个函数，检查链表是否为回文.
 * Created by LCN on 2016/3/28.
 */
public class __2_7IsPalindrome {

    public static boolean isPalindrome(LinkedListNode head) {

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }


        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
