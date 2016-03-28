package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 实现一个算法，确定一个字符中的所有字符是否全部不同。
 * 假使不允许使用额外的数据结构
 * Created by LCN on 2016/3/28.
 */
public class __1_1IsUniqueChars {

    public static boolean isUniueChar(String str) {
        if (str.length() > 256 ) return false;
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]){   //如果该字符已经在前面出现过
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
