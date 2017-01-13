package CN.EDU.SEU.leetcode;

public class Solution_205 {
	public boolean isIsomorphic(String s, String t) {
		char[][] arr = new char[2][s.length()];
		int[][] diff = new int[2][127];

		arr[0] = s.toCharArray();
		arr[1] = t.toCharArray();

		int indexS = 0;
		int indexT = 0;
		int num = 0;

		for (int i = 0; i < arr[0].length; i += 1) {
			indexS = arr[0][i];
			indexT = arr[1][i];
			diff[0][indexS] = diff[1][indexT] = arr[0][i] - arr[1][i];
		}
		for (int i = 0; i < arr[0].length; i += 1) {
			indexS = arr[0][i];
			indexT = arr[1][i];
			num = arr[0][i] - arr[1][i];
			if (diff[0][indexS] != num || diff[1][indexT] != num) {
				return false;
			}
		}
		return true;
	}

	public boolean isIsomorphic2(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s == "")
			return t == "";
		if (t == "")
			return false;

		if (s.length() != t.length()) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (s.lastIndexOf(c1) != t.lastIndexOf(c2))
				return false;
		}

		return true;
	}
}
