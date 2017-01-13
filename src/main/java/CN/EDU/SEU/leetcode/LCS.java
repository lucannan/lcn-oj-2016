package CN.EDU.SEU.leetcode;

public class LCS {

	public static int longestCommonSubsequence(String s, String t) {
		if (s == null || t == null) {
			return 0;
		}
		int lenS = s.length();
		int lenT = t.length();
		int[][] dp = new int[lenT + 1][lenS + 1];
		for (int i = 0; i <= lenT; i++) {
			for (int j = 0; j <= lenS; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (t.charAt(i - 1) == s.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}

		}

		return dp[lenT][lenS];
	}

	public static int longestCommonSubsequence2(String A, String B) {
		// write your code here
		if (A == null || B == null) {
			return 0;
		}

		int lenA = A.length();
		int lenB = B.length();
		int[][] D = new int[lenA + 1][lenB + 1];

		for (int i = 0; i <= lenA; i++) {
			for (int j = 0; j <= lenB; j++) {
				if (i == 0 || j == 0) {
					D[i][j] = 0;
				} else {
					if (A.charAt(i - 1) == B.charAt(j - 1)) {
						D[i][j] = D[i - 1][j - 1] + 1;
					} else {
						D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
					}
				}
			}
		}

		return D[lenA][lenB];
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ABCD", "EDCA"));
		System.out.println(longestCommonSubsequence("EACB", "ABCD"));
		System.out.println(longestCommonSubsequence("ABCD", "EACB"));

		System.out.println(longestCommonSubsequence2("ABCD", "EACB"));

	}
}
