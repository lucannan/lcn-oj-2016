package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_155 {
	public class MinStack {
		
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		/** initialize your data structure here. */
		public MinStack() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int x) {
			if(this.stackMin.isEmpty()){
				this.stackMin.push(x);
			}else if(x <= this.getMin()){
				this.stackMin.push(x);
			}
			this.stackData.push(x);
		}

		public void pop() {
			if(this.stackData.isEmpty()){
				return;
			}
			int value = this.stackData.pop();
			if (value == this.getMin()){
				this.stackMin.pop();
			}
		}

		public int top() {
			return this.stackData.peek();
		}

		public int getMin() {
			return this.stackMin.peek();
		}
	}
}
