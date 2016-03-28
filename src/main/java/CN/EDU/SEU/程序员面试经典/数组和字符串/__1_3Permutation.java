package CN.EDU.SEU.程序员面试经典.数组和字符串;

import java.util.Arrays;

/**
 * 给定两个字符串，请编写代码，确定其中一个字符串的字符重新排序后，
 * 能否再变成另外一个字符
 * Created by LCN on 2016/3/28.
 */
public class __1_3Permutation {

    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }


    public static boolean permutation(String s, String t) {
        if (s.length() != t.length())
            return false;

        return sort(s).equals(sort(t));
    }


    public static boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letter = new int[256];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letter[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);

            if (--letter[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
