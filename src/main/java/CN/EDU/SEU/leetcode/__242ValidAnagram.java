package CN.EDU.SEU.leetcode;

/**
 * 时间复杂度O(N) N代表字符串的长度
 * 空间复杂度O(1)
 * Created by LCN on 2016/4/12.
 */
public class __242ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null && t != null) {
            return false;
        } else if (s != null && t == null) {
            return false;
        } else {
            if (s.length() != t.length()) {
                return false;
            }
            int n = s.length();
            int twentySix = 26;
            int[] sTable = new int[twentySix];
            int[] tTable = new int[twentySix];

            for (int i = 0; i < n; i++) {
                sTable[s.charAt(i) - 'a']++;
                tTable[t.charAt(i) - 'a']++;
            }

            for (int i = 0; i < twentySix; i++) {
                if (sTable[i] != tTable[i])
                    return false;
            }
            return true;
        }
    }
}
