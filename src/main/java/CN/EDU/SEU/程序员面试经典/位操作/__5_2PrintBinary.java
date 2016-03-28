package CN.EDU.SEU.程序员面试经典.位操作;

/**
 * 给定一个介于0和1之间的实数（如0.72）,类型为double，打印它的
 * 二进制表示。如果该数字无法精确的用32位以内的二进制表示，打印error
 * Created by LCN on 2016/3/27.
 */
public class __5_2PrintBinary {


    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "error";
        }


        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "error";
            }
            double r = num * 2;
            if (r >= 1) {
                sb.append(1);
                num = num - 1;
            } else {
                sb.append(0);
                num = r;
            }

        }
        return sb.toString();
    }


    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "error";
        }
        double frac = 0.5;
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() > 32) {
                return "error";
            }
            if (num >= frac) {
                sb.append(1);
                num -= frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(printBinary(0.011));
    }
}
