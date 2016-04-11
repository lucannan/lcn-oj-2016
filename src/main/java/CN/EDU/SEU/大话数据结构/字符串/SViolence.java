package CN.EDU.SEU.大话数据结构.字符串;

/**
 * Created by LCN on 2016/4/11.
 */
public class SViolence {

    /**
     * 返回子串T在主串S中第pos个字符之后的位置。如果不存在，则函数返回值为-1
     * @param s
     * @param t
     * @return
     */
    public static int index(String s, String t, int pos) {
        int i = pos;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {   //指针后退重新开始
                i = i - j + 1;   //退回到上一次匹配的首位的下一个位置
                j = 0;
            }
        }

        if (j == t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(index("avdshelldsohello world","hello",0));
    }
}
