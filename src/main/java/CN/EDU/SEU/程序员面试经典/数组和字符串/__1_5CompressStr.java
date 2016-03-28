package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如aabcccccaaa   a2b1c5a3  如果压缩后的字符串没有变短，则返回原先的
 * 字符串
 * Created by LCN on 2016/3/28.
 */
public class __1_5CompressStr {

    public static String compressBad(String str) {
        String myStr = "";
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                myStr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }
        return myStr + last + count;  //最后一个字符的拼接
    }


    /**
     * 计算压缩以后的字符串的长度
     *
     * @param str
     * @return
     */
    public static int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0;

        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size = size + 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size = size + 1 + String.valueOf(count).length();
        return size;
    }


    public static String compressBetter(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuilder myStr = new StringBuilder();

        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                myStr.append(last);
                myStr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        myStr.append(last);
        myStr.append(count);
        return myStr.toString();
    }
}
