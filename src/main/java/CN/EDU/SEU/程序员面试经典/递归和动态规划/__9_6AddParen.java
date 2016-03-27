package CN.EDU.SEU.程序员面试经典.递归和动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * P230
 * 实现一个算法，打印n对括号的全部有效组合（左右括号正确配对）
 * Created by LCN on 2016/3/27.
 */
public class __9_6AddParen {


    /**
     * @param list
     * @param leftRem
     * @param rightRem
     * @param str
     * @param count
     */
    public static void addparen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return; //无效状态

        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            //如果有左括号可以用，加入一个左括号
            if (leftRem > 0) {
                str[count] = '(';
                addparen(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addparen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }



    public static void main(String[] args) {
        int count = 5;
        char[] str = new char[count*2];
        List<String> list = new ArrayList<String>();
        addparen(list, count, count, str, 0);

        for (String s:list){
            System.out.println(s);
        }

        System.out.println(list.size());
    }
}
