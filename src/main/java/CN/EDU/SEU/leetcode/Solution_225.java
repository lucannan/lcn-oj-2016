package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_225 {
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	int top;

	// Push element x onto stack.
	public void push(int x) {
		list.add(x);
		top = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		// add back all the front elements at the end except last one
		for (int i = 0; i < list.size() - 1; i++) {
			push(list.remove());
		}
		list.remove(); // remove the top which is now at the front
	}

	// Get the top element.
	public int top() {
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return list.size() == 0;
	}
}
