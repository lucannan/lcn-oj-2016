package CN.EDU.SEU.leetcode;

import java.util.*;

public class Soution_241 {

	public int calculate(int num1, int num2, char operator) {
		int result = 0;
		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;

		}
		return result;
	}

	public boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*') {
			return true;
		}
		return false;
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (isOperator(input.charAt(i))) {
				char oper = input.charAt(i);
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int num1 : left)
					for (int num2 : right) {
						result.add(calculate(num1, num2, oper));
					}
			}
		}

		if (result.size() == 0) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}
}
