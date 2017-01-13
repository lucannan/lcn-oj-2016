package CN.EDU.SEU.leetcode;

public class Solution_11 {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) { // should move i
				int k;
				for (k = i + 1; k < j && height[k] <= height[i]; ++k) {
				}
				i = k;
			} else { // should move j
				int k;
				for (k = j - 1; k > i && height[k] <= height[j]; --k) {
				}
				j = k;
			}
		}
		return max;
	}
}
