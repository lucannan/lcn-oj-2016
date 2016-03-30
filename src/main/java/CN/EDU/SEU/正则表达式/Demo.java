package CN.EDU.SEU.正则表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LCN on 2016/3/20.
 */
public class Demo {


    @Test
    public void test1() {
        //在这个字符串：asfsdf23323，是否符合指定的正则表达式：\w+
        //表达式对象
        Pattern p = Pattern.compile("\\w+");
        //创建Matcher对象
        Matcher m = p.matcher("asfsdf2&&3323");
        Matcher m1 = p.matcher("helloworld");
        boolean yesorno = m1.matches();    //尝试将整个字符序列与该模式匹配
        System.out.println(yesorno);
        while (m.find()) {
            System.out.println(m.group());    //group(),group(0)匹配整个表达式的子字符串
            System.out.println(m.group(0));
        }
    }


    @Test
    public void test2() {
        //在这个字符串：asfsdf23323，是否符合指定的正则表达式：\w+
        //表达式对象
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        //创建Matcher对象
        Matcher m = p.matcher("aa232**ssd445*sds223");

        while (m.find()) {
            System.out.println(m.group());    //group(),group(0)匹配整个表达式的子字符串
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }


    @Test
    public void test3() {
        //表达式对象
        Pattern p = Pattern.compile("[0-9]");
        //创建Matcher对象
        Matcher m = p.matcher("aa232**ssd445*sds223");
        //替换
        String newStr = m.replaceAll("#");
        System.out.println(newStr);
    }


    @Test
    public void test4() {
        String str = "a232b4334c3434";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));
    }


}
