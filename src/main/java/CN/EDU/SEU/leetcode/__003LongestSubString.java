package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/3/22.
 */

/**
 * Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without
 * repeating letters for "abcabcbb" is "abc", which the length is
 * 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class __003LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int[] locs = new int[256];
        for (int i = 0; i < locs.length; i++) {
            locs[i] = -1;
        }
        int idx = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locs[s.charAt(i)] > idx) {
                idx = locs[s.charAt(i)];
            }
            if (i - idx > max) {
                max = i - idx;
            }
            locs[s.charAt(i)] = i;
        }
        return max;
    }
}
