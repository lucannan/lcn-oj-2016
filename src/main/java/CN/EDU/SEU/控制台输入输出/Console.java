package CN.EDU.SEU.控制台输入输出;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by LCN on 2016/3/20.
 * 常用构造方法:
 *  Scanner(File source): 构造一个新的Scanner，它生成的值是从指定文件扫描的。
 *  Scanner(InputStream source): 构造一个新的 Scanner，它生成的值是从指定的输入流扫描的。
 *   Scanner(String source): 构造一个新的Scanner，它生成的值是从指定字符串扫描的。
 * <p>
 * 要想读取并转换下一个表示整数或浮点数的字符序列,就调用
 * int nextInt( )
 * double nextDouble( )
 * <p>
 * 要想检测输入中是否还有其他单词
 * boolean hasNext( )
 * boolean hasNextInt( )
 * boolean hasNextDouble( )
 */

/**常用构造方法:
 *   Scanner(File source): 构造一个新的Scanner，它生成的值是从指定文件扫描的。
 *   Scanner(InputStream source): 构造一个新的 Scanner，它生成的值是从指定的输入流扫描的。
 *    Scanner(String source): 构造一个新的Scanner，它生成的值是从指定字符串扫描的。
 */


/**
 * 要想读取并转换下一个表示整数或浮点数的字符序列,就调用
 * int nextInt( )
 * double nextDouble( )
 *
 * 要想检测输入中是否还有其他单词
 * boolean hasNext( )
 * boolean hasNextInt( )
 * boolean hasNextDouble( )
 */


/**
 * 要想修改默认以空格作为分割符来区分不同的单词,就可以使用
 * Scanner useDelimiter(Demo pattern); //将扫描器的分隔模式设置为指定模式
 * Scanner useDelimiter(String pattern); //将此扫描器的分隔模式设置为从指定String构造的模式
 */


/**
 * 控制台打印
 * ava在控制台上打印输出一般不会有格式化的要求。
 * 例如我们可以使用System.out.print(x) 将数值x输出到控制台上。
 * 这条命令将以x对应的数据类型所允许的最大非0数字位数打印输出x
 */

@SuppressWarnings("all")
public class Console {

    public static void main(String[] args) {
        //读入一行
//        Scanner in = new Scanner(System.in,"UTF-8");
//        System.out.println("what is your name?");
//        String name = in.nextLine();//读取输入的下一行内容
//        System.out.println("Your name is "+name);

        //读入单个字 空格分开
        //在这里,使用nextLine方法是因为在输入行中有可能包含空格。
        // 要想读取一个单词（默认是以空白符作为分隔符）,就调用
//        Scanner in = new Scanner(System.in,"UTF-8");
//        System.out.println("what is your name?");
//        String word = null;
//        while(in.hasNext()){
//            word = in.next();
//            System.out.println("word "+ word);
//
//        }

        System.out.println(5.6666);

        System.out.printf("%f\n",5.3);

        String message = String.format("Hello %1$s.Next year,you'll be %2$d.%n","Jan mi",23);
        System.out.println(message);
    }

    @Test
    public void test1() {
        //在这里,使用nextLine方法是因为在输入行中有可能包含空格。
        // 要想读取一个单词（默认是以空白符作为分隔符）,就调用
        String text = "lu can nan";
//        Scanner in = new Scanner(System.in,"UTF-8");
        Scanner in = new Scanner(text);

        System.out.println("what is your name?");
        String firstname = in.next();//读取输入的下一个单词（以空格作为分隔符）
        System.out.println("Your firstName is " + firstname);
    }


    @Test
    public void test2(){
        String text = "lu/can/nan";
        Scanner in = new Scanner(text);
        in.useDelimiter("/");
        String word = "";
        int count = 0;
        while(in.hasNext()){
            word = in.next();
            System.out.println("word" + count +" " + word);
            count++;
        }
    }

    @Test
    public void test3() throws FileNotFoundException {
        String filepath = "F:\\jetbrain\\idea\\JOB\\src\\main\\java\\CN\\EDU\\SEU\\控制台输入输出\\out.txt";
        InputStream in = new FileInputStream(filepath);
        Scanner scanner = new Scanner(in,"UTF-8");
        int count = 0;
        while (scanner.hasNextInt()){
            int value = scanner.nextInt();
            System.out.println("val" + count +" " + value);
            count++;
        }
    }

    @Test
    public void test4() throws IOException {
        StringBuilder sb = new StringBuilder();
        String filepath = "F:\\jetbrain\\idea\\JOB\\src\\main\\java\\CN\\EDU\\SEU\\控制台输入输出\\text.txt";
        InputStream in = new FileInputStream(filepath);
        Scanner scanner = new Scanner(in,"UTF-8");
        int count = 0;
        while (scanner.hasNextInt()){
            int value = scanner.nextInt();
            System.out.println("val" + count +" " + value);
            count++;
            sb.append(value);
            sb.append(" ");
        }

        FileOutputStream fop = null;
        File out = new File("F:\\jetbrain\\idea\\JOB\\src\\main\\java\\CN\\EDU\\SEU\\控制台输入输出\\out.txt");
        fop = new FileOutputStream(out);

        fop.write(sb.toString().getBytes());
        fop.flush();
        fop.close();
    }

    @Test
    public void test5() throws FileNotFoundException {
        File out = new File("F:\\jetbrain\\idea\\JOB\\src\\main\\java\\CN\\EDU\\SEU\\控制台输入输出\\out2.txt");
        FileOutputStream fop = new FileOutputStream(out);
        PrintWriter outwriter = new PrintWriter(fop);

        outwriter.printf("hello world");
        outwriter.close();
        System.out.println("end");
    }

}
