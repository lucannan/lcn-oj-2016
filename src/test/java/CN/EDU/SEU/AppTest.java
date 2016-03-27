package CN.EDU.SEU;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by LCN on 2016/3/20.
 */

public class AppTest {

//    public static void main(String[] args) throws Throwable {
//        Map<String,String> map = new HashMap<String, String>();
//        map.put(null,"lucannan");
//        map.get(null);
//
//    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String password = in.nextLine();
        char[] password_char = password.toCharArray();
        int count = 0; //统计9和g的个数
        for (int i = 0; i < password.length(); i++) {
            if (password_char[i] == 'g' || password_char[i] == '9')
                count++;
        }
        Map<String, String> map = new HashMap<String, String>();
        char[] temp = password_char.clone();
        for (int i = 0; i < count; i++) {
            int countnum = 0;
            for (int j = 0; j < password.length(); j++) {
                countnum = 0;
                if (temp[j] == 'g') {
                    temp[j] = '9';
                    countnum++;
                    if (!map.containsKey(new String(temp))) {
                        map.put(new String(temp), "1");
                    }
                    if (countnum > i) {
                        temp = password_char.clone();
//                        countnum = 0;
                    }
                    continue;
                } else if (temp[j] == '9') {
                    temp[j] = 'g';
                    countnum++;
                    if (!map.containsKey(new String(temp))) {
                        map.put(new String(temp), "1");
                        temp = password_char.clone();
                    }
                    if (countnum > i) {
                        temp = password_char.clone();
//                        countnum = 0;
                    }
                    continue;
                }
            }
        }

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            System.out.println(key);
        }
        //打印自身
        System.out.println(password);


    }
}
