package CN.EDU.SEU.leetcode;

public class Solution_08 {
	public int myAtoi(String str) {
		long ans = 0;
		boolean isNeg = false;
		char[] strChar = str.toCharArray();
		int len = str.length();
		boolean toNumChar = false;
		for (int i = 0; i < len; i++) {
			if ((strChar[i] == '-' || strChar[i] == '+') && toNumChar == false) {
				toNumChar = true;
				isNeg = strChar[i] == '-' ? true : false;
			} else if (strChar[i] >= '0' && strChar[i] <= '9') {
				toNumChar = true;
				int num = strChar[i] - '0';
				ans = ans * 10 + num;
				if (isNeg) {
					ans = -ans;
				}
				if (ans > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (ans < Integer.MIN_VALUE) {
					return Integer.MAX_VALUE;
				}

				if (isNeg) {
					ans = -ans;
				}
			} else if (toNumChar && (strChar[i] < '0' || strChar[i] > '9')){
				break;

			}else if (strChar[i] == ' ' && toNumChar == false) {//pass the whitespace
                ; 
            }
			else {
				return 0;
			}
		}
		ans = isNeg ? -ans : ans;

		return (int) ans;
	}
}
