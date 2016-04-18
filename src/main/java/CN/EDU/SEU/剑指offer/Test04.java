package CN.EDU.SEU.剑指offer;

import org.junit.Test;

/**
 * 替换空格
 * Created by LCN on 2016/4/18.
 */
public class Test04 {

    public static int replaceBlank(char[] str, int length) {
        if (str == null || str.length < length) {
            return -1;
        }

        int whiteCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                whiteCount++;
            }
        }
        int targetLength = length + whiteCount * 2;
        int tmp = targetLength; // 保存长度结果用于返回

        if (targetLength > str.length) {
            return -1;
        }

        if (whiteCount == 0) {
            return length;
        }

        length--;
        targetLength--;

        while (length >= 0 ) {
            if (str[length] == ' ') {
                str[targetLength--] = '0';
                str[targetLength--] = '2';
                str[targetLength--] = '%';
            } else {
                str[targetLength--] = str[length];
            }
            length--;
        }
        return tmp;
    }

    @Test
    public void test01(){
        String str = "he l lo w orld ";
        char[] result = new char[50];
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            result[i] = strArr[i];
        }
        int length = replaceBlank(result,strArr.length);

        System.out.println(new String(result,0,length));

    }
}
