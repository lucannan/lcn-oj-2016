package TengXun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int LonggestPalindrome(String str, int n) {
        int max = 0, c = 0;
        if (str == null || n < 1) {
            return 0;
        }
        char[] strArr = str.toCharArray();
        max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; (i - j >= 0) && (i + j < n); j++) {
                if (strArr[i - j] != strArr[i + j]) {
                    break;
                }
                c = j * 2 + 1;
            }
            if (c > max)
                max = c;

            for (int j = 0; (i - j) >= 0 && (i + j + 1 < n); j++) {
                if (strArr[i - j] != strArr[i + j + 1])
                    break;
                c = j * 2 + 2;
            }
            if (c > max)
                max = c;


        }
        return max;
    }

    public static boolean judge(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return reverse.equals(s);
    }


    public static int perm(String s, List<String> result, List<String> total) {
        for (int i = s.length(); i >= 1; i--) {
            total.clear();
            int data = perm(s, i, result, total);
            if (data == 1) {
                return total.get(total.size()-1).length();
            }
            total.clear();
        }
        return 0;
    }

    public static int perm(String s, int m, List<String> result, List<String> total) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
            }
            String temp = sb.toString();
            if (judge(temp)) {
                total.add(temp);
                return 1;
            }
            return -1;
        }

        if (s.length() != 0) {
            result.add(s.charAt(0) + "");
            int temp = 0;
            temp = perm(s.substring(1, s.length()), m - 1, result, total);
            if (temp == 1) {
                return 1;
            }
            result.remove(result.size() - 1);
            temp = perm(s.substring(1, s.length()), m, result, total);
            if (temp == 1){
                return 1;
            }
        }
        return -1;
    }


    public static void dfs(String s, List<String> data, int number) {
        if (number == s.length()) {
            data.add(s);
            return;
        }
        String temp = s;
        dfs(s, data, number + 1);
        s = temp;
        s = s.substring(0, number) + s.substring(number + 1, s.length());
        dfs(s, data, number + 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            List<String> total = new ArrayList<String>();
            List<String> result = new ArrayList<String>();
//            for (int i = 1; i <= s.length(); i++) {
//                perm(s, i, result, total);
//            }
//            int max = 0;
//            for (String temp : total) {
//                int ret = LonggestPalindrome(temp, temp.length());
//                if (ret > max) {
//                    max = ret;
//                }
//            }
            int temp = 0;
            while (true) {
                temp = perm(s, total, total);
                if (temp != 0) {
//                    System.out.println(temp.length());
                    break;
                }
            }
//
            System.out.println(temp);
        }

    }
}
