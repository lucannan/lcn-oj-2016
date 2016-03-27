package CN.EDU.SEU;

import java.util.*;

/**
 * Created by LCN on 2016/3/22.
 */
public class App {

    public static void addParen(ArrayList<String> list, char[] str, int number) {
        if (number < -1) return;
        if (number == -1) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (str[number] == 'g' || str[number] == '9') {
                str[number] = 'g';
                addParen(list, str, number - 1);
                str[number] = '9';
                addParen(list, str, number - 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        char[] password_char = word.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, password_char, password_char.length - 1);
        Set<String> set = new HashSet<String>();
        for (String s : list) {
            System.out.println(s);
            set.add(s);
        }

        System.out.println(set.size());
    }
}