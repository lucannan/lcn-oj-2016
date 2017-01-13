package CN.EDU.SEU.leetcode;

public class Solution_405 {
	public String toHex(int num) {
		StringBuilder sb = new StringBuilder();
		if (num == 0)
			return "0";
		int sign = 1;
		int bitNum = 8;
		if (num < 0) {
			num = -num - 1;
			sign = -1;
		}

		while (sign == 1 && num != 0) { // num is positive
			int rest = num % 16;
			if (rest < 10) {
				sb.append(rest);
			} else {
				sb.append((char) ('a' + rest - 10));
			}
			num /= 16;
		}

		while (sign == -1 && bitNum > 0) { // num is negative
			int rest = num % 16;
			if (rest < 6) {
				sb.append((char) ('f' - rest));
			} else {
				sb.append(15 - rest);
			}
			num /= 16;
			bitNum--;
		}

		return sb.reverse().toString();
	}
}
