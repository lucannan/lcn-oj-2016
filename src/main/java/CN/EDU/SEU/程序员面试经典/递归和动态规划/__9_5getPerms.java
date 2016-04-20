package CN.EDU.SEU.程序员面试经典.递归和动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个方法，确定某字符串的所有排列组合的方法
 * Created by LCN on 2016/3/27.
 */
class __9_5GetPerms {


    public static List<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        List<String> permutations = new ArrayList<String>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);  //取得第一个字符串
        String remainder = str.substring(1);
        List<String> words = getPerms(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }

        return permutations;
    }


    /**
     * 在字符串中的某个位置插入某个字符
     *
     * @param word
     * @param c
     * @param i
     * @return
     */
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list = getPerms("abc");

        for (String s : list){
            System.out.println(s);
        }
    }
}
