package CN.EDU.SEU.leetcode;

/**
 * 最后一个单词的长度
 * Created by LCN on 2016/4/13.
 */
public class __058LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 ){
            return 0;
        }
        char[] strArrary = s.toCharArray();
        boolean state = false;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && state == false){
                continue;
            }else if (s.charAt(i) == ' ' && state == true){
                break;
            }

            if (s.charAt(i) != ' '){
                state = true;
                result ++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        for (int b : a){
            System.out.println(b);
        }
//        System.out.println(lengthOfLastWord("hello world   "));
    }
}
