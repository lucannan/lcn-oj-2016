package CN.EDU.SEU.程序员面试经典.链表;

import CN.EDU.SEU.几个常用数据结构.Stack;

/**
 * P128
 * 编写一个函数，检查链表是否为回文.
 * Created by LCN on 2016/3/28.
 */
public class __2_7IsPalindrome {
    /**
     * 迭代法
     * @param head
     * @return
     */
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

    /***
     * 递归方法
     * @param head
     * @param length
     * @return
     */
    public static Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else if (length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);
        if (!res.result || res.node == null) {
            return res;
        } else {
            res.result = head.data == res.node.data;
            res.node = res.node.next;
            return res;
        }
    }

    /**
     * 计算链表的长度
     * @param node
     * @return
     */
    public static int listSize(LinkedListNode node){
        int count = 0;
        LinkedListNode temp = node;
        while (temp!=null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static boolean isPalindrome2(LinkedListNode head){
        Result result = isPalindromeRecurse(head,listSize(head));
        return result.result;
    }


    public static void main(String[] args) {

    }
}


class Result {
    public LinkedListNode node;
    public boolean result;

    public Result(LinkedListNode node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
