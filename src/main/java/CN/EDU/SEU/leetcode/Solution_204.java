package CN.EDU.SEU.leetcode;

public class Solution_204 {
	public int countPrimes(int n) {
		boolean[] m = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (m[i])
				continue;

			count++;
			for (int j = i; j < n; j = j + i)
				m[j] = true;
		}

		return count;
	}
}
