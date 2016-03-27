package CN.EDU.SEU.程序员面试经典.递归和动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回某个集合中所有的子集
 * Created by LCN on 2016/3/27.
 */
public class __9_4GetSubsets {

    /**
     * 每个整数表示一个子集
     *
     * @param number
     * @param count
     * @param list
     */
    public static void getSubsets(Integer number, int count, List<Integer> list) {
        if (count < 0) {
            return;
        } else if (count == 0) {
            list.add(number);
            return;
        } else {
            int temp = number;  //保存状态
            number = number | (1 << (count - 1));
            getSubsets(number, count - 1, list);
            number = temp;
            number = number & (~(1 << (count - 1)));
            getSubsets(number, count - 1, list);
        }
    }


    public static void main(String[] args) {
        List<Integer> result = new ArrayList<Integer>();
        getSubsets(0, 4, result);
        System.out.println(result.size());
        char[] str = {'a', 'b', 'c', 'd'};
        int count = 0;
        for (Integer data : result) {
            String s = Integer.toBinaryString(data);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append(str[str.length - s.length() + i]);
                }
            }
            sb.append(" ").append(Integer.toBinaryString(data));
            System.out.println(sb.toString());
        }
    }
}
