package CN.EDU.SEU.leetcode;


public class Solution_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 != null ? l1 : l2;
		}

		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode cur1 = head == l1 ? l1 : l2;
		ListNode cur2 = head == l1 ? l2 : l1;
		ListNode pre = null;
		ListNode next = null;
		while (cur1 != null && cur2 != null) {
			if(cur1.val <= cur2.val){
				pre = cur1;
				cur1 = cur1.next;
			}else{
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
