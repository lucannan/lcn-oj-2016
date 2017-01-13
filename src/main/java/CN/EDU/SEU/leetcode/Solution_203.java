package CN.EDU.SEU.leetcode;

public class Solution_203 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null || head.next == null && head.val == val) {
			return null;
		}
		if (head.next == null && head.val != val) {
			return head;
		}
		// Keep removing head until head.val!=val
		while (head != null && head.val == val)
			head = head.next;

		ListNode curr = head;

		while (curr != null) {
			if (curr.next != null && curr.next.val == val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}
}
