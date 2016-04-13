package CN.EDU.SEU.leetcode;

import org.junit.Test;

/**
 * 字符串匹配暴力破解
 * 高级的算法可以使用KMP
 * Created by LCN on 2016/4/12.
 */
public class __028ImplementstrStr {
    //暴力破解
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n && i + j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == n) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String s = "aabbccagdbbccdec";
        String p = "bbccd";
        System.out.println(strStr(s, p));
        System.out.println(s.indexOf(p));
        p = "bbccf";
        System.out.println(strStr(s, p));
        System.out.println(s.indexOf(p));
    }
}
