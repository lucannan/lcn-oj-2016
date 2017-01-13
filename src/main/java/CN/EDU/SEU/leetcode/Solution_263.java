package CN.EDU.SEU.leetcode;

public class Solution_263 {
	public boolean isUgly(int num) {
		if (num == 0)
			return false;
		if (num == 1)
			return true;
		return factorize(num);
	}

	private boolean factorize(int num) {
		if (num == 1)
			return true;
		if (num % 5 == 0) {
			num = num / 5;
			return factorize(num);
		} else if (num % 3 == 0) {
			num = num / 3;
			return factorize(num);
		} else if (num % 2 == 0) {
			num = num / 2;
			return factorize(num);
		}
		return false;
	}
}
