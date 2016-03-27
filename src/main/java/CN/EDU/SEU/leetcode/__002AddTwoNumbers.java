package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/3/22.
 */


import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class __002AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode templ1 = l1;
        ListNode templ2 = l2;

        Stack<Integer> l1Stack = new Stack<Integer>();
        while (templ1 != null) {
            l1Stack.add(templ1.val);
            templ1 = templ1.next;
        }
        Stack<Integer> l2Stack = new Stack<Integer>();
        while (templ2 != null) {
            l2Stack.add(templ2.val);
            templ2 = templ2.next;
        }
        int length1 = l1Stack.size();
        int num1 = 0;
        for (int i = length1; i > 0; i--) {
            int exp = 1;
            int temp = i;
            while (--temp > 0) {
                exp = exp * 10;
            }
            num1 += l1Stack.pop() * exp;
        }

        int length2 = l2Stack.size();
        int num2 = 0;
        for (int i = length2; i > 0; i--) {
            int exp = 1;
            int temp = i;
            while (--temp > 0) {
                exp = exp * 10;
            }
            num2 += l2Stack.pop() * exp;
        }

        int total = num1 + num2;
        ListNode result = new ListNode(total % 10);
        ListNode temp = result;
        total = total / 10;
        while (total > 0) {
            temp.next = new ListNode(total % 10);
            total = total / 10;
            temp = temp.next;

        }

        return result;
    }

    //只有这个测试可以通过
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuffer l1Str = new StringBuffer();
        StringBuffer l2Str = new StringBuffer();
        while (l1 != null) {
            l1Str.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Str.append(l2.val);
            l2 = l2.next;
        }

        long l1Int = Long.parseLong(l1Str.reverse().toString());
        long l2Int = Long.parseLong(l2Str.reverse().toString());
        long sum = l1Int + l2Int;
        int val = (int) (sum % 10);
        sum = sum / 10;
        ListNode answerNode = new ListNode(val);
        ListNode tempNode, tempnode1;
        tempnode1 = answerNode;
        while (sum > 0) {
            val = (int) (sum % 10);
            sum = sum / 10;
            tempNode = new ListNode(val);
            tempnode1.next = tempNode;
            tempnode1 = tempnode1.next;
        }
        return answerNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);

//        ListNode result = addTwoNumbers(l1, l2);
        ListNode result2 = addTwoNumbers2(l1,l2);


        System.out.println("============");
    }
}
