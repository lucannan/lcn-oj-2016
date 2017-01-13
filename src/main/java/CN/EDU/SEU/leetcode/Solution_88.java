package CN.EDU.SEU.leetcode;

public class Solution_88 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			for(int i =0 ;i <n ;i++){
				nums1[i] = nums2[i];
			}
			return;
		}

		int aIndex = m - 1;
		int bIndex = n - 1;

		for (int i = 0; i < n + m; i++) {
			long a = Long.MIN_VALUE;
			long b = Long.MIN_VALUE;

			if (bIndex < 0) {
				return;
			}

			if (aIndex >= 0) {
				a = nums1[aIndex];
			}
			if (bIndex >= 0) {
				b = nums2[bIndex];
			}

			if (a <= b) {
				bIndex--;
				nums1[n + m - 1 - i] = (int) b;

			} else {
				aIndex--;
				nums1[n + m - 1 - i] = (int) a;
			}
		}
	}

	public static void main(String[] args) {
	}
}
