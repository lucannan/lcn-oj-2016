package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 编写一个方法，将字符串中的空格全部替换为“%20”
 * 假定该字符串尾部有足够的空间存放新增的字符，并且知道字符串的真实长度
 * Created by LCN on 2016/3/28.
 */
public class __1_4ReplaceSpaces {

    public static void replaceSpace(char[] str, int length) {
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + 2 * spaceCount;
        str[newLength] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }
}
