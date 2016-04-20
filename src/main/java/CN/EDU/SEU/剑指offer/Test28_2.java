package CN.EDU.SEU.剑指offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 剑指offer 28 引申题
 * Created by LCN on 2016/4/20.
 */
public class Test28_2 {


    public static List<Set<Character>> dfs(char[] data) {
        if (data == null || data.length < 1) {
            return null;
        }
        Set<Character> subresult = new HashSet<>();
        List<Set<Character>> result = new LinkedList<>();
        dfs(data, 0, subresult, result);
        return result;
    }

    public static void dfs(char[] data, int index, Set<Character> subresult, List<Set<Character>> result) {
        if (index >= data.length) {

            result.add(new HashSet<Character>(subresult));
            return;
        }
        dfs(data, index + 1, subresult, result);
        subresult.add(data[index]);
        dfs(data, index + 1, subresult, result);
    }

    @Test
    public void test01() {
        String data = "abcd";
        List<Set<Character>> result = dfs(data.toCharArray());
        System.out.println(result.size());

        for (Set<Character> subresult :
                result) {
            for (char c :
                    subresult) {
                if (subresult.isEmpty()) {
                    return;
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
