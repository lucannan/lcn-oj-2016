package CN.EDU.SEU.字符串;

import org.junit.Test;

/**
 * Created by LCN on 2016/3/20.
 */
public class StringUtils {
    /**
     * 在str右边加入足够多的addStr字符串
     * @param str
     * @param addStr
     * @param length
     * @return
     */
    public static String addStringRight(String str, String addStr, int length) {
        StringBuilder builder = new StringBuilder(str);
        while (builder.length() < length) {
            builder.append(addStr);
        }
        return builder.toString();
    }


    /**
     * 计算字符串str中字符sub的个数
     * @param str
     * @param sub
     * @return
     */
    public static int charCount(String str, char sub) {
        if (str == null){
            return 0;
        }
        int charCount = 0;
        int fromIndex = 0;
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            fromIndex++;
            charCount++;
        }
        return charCount;
    }


//    /**
//     * 计算字符串str右边出现多少次sub
//     * @param str
//     * @param sub
//     * @return
//     */
//    public static int charCountRight(String str, String sub) {
//        if (str == null) {
//            return 0;
//        }
//        int charCount = 0;
//        String subStr = str;
//        int currentLength = subStr.length() - sub.length();
//        while (currentLength >= 0 && subStr.substring(currentLength).equals(sub)) {
//            charCount++;
//            subStr = subStr.substring(0, currentLength);
//            currentLength = subStr.length() - sub.length();
//        }
//        return charCount;
//    }

    public static void main(String[] args) {
        String text = "hello world";
        text = StringUtils.addStringRight(text,"a",20);
        System.out.println(text);

        System.out.println(StringUtils.charCount(text,'a'));
    }


    @Test
    public void test1(){
        String text = "hello world world world";
//        System.out.println(StringUtils.charCountRight(text,"world"));
    }
}
