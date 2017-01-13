package CN.EDU.SEU.leetcode;

public class Solution_344 {
	public String reverseString(String s) {
		if (s == null)
			return null;
		if (s.equals(""))
			return s;
		char[] arrChar = s.toCharArray();
		for (int i = 0, j = arrChar.length - 1; i <= j; i++, j--) {
			char temp = arrChar[i];
			arrChar[i] = arrChar[j];
			arrChar[j] = temp;
		}
		return new String(arrChar);
	}
}
