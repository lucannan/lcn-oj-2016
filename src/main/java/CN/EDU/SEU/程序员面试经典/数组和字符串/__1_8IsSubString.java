package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 假定有一个方法isSubString 可检查一个单词是否为其他字符串的字串
 * 给定字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 * Created by LCN on 2016/3/28.
 */
public class __1_8IsSubString {

    public static boolean isRotation(String s1,String s2){

        int len = s1.length();

        if (len == s2.length() && len > 0){
            String s1s1 = s1 + s1;
            return isSubString(s1s1,s2);
        }
        return false;
    }

    //判断一个字符串是否为另一个字符串的子串
    private static boolean isSubString(String s1s1, String s2) {
        return true;
    }
}
