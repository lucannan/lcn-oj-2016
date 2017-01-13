package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_202 {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		/* set result to input number, if n > 1, go into the while loop */
		int res = n;
		/*
		 * >1 number will appear in loop, use HashSet to find repetitive sum of
		 * square digits
		 */
		Set<Integer> set = new HashSet<Integer>();
		/* The loop ends when res = 1 or when repetitive number appear */
		while (res > 1) {
			if (!set.add(res)) {
				return false;
			}
			set.add(res);
			res = SquareOfDigits(res);
		}
		return true;
	}

	/* The following method add up the square of digits of input number */
	private int SquareOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum + (int) Math.pow(n % 10, 2);
//			System.out.println("digit: " + n % 10);
			n = n / 10;
		}
//		System.out.println("Sum: " + sum);
		return sum;
	}
}
