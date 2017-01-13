package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_24 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode resign1(Stack<Integer> stack, ListNode left, ListNode right) {
		int value = stack.pop();
		
		
		ListNode cur = new ListNode(value);
		if (left != null) {
			left.next = cur;
		}
		
		ListNode next = null;
		while (!stack.isEmpty()) {
			next = new ListNode(stack.pop());
			cur.next = next;
			cur = next;
		}

		cur.next = right;
		return cur;
	}

	public static ListNode reverseKNode1(ListNode head, int k) {
		if(k < 2){
			return head;
		}
		Stack<Integer> stack = new Stack<Integer>();
		ListNode newHead = head;
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		
		while(cur != null){
			next = cur.next;
			stack.push(cur.val);
			if(stack.size() == k){
				pre = resign1(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = cur.next;
		}
		
		return newHead;
	}
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		
		ListNode reverse = reverseKNode1(node,2);
		
		System.out.println();
	}

}
