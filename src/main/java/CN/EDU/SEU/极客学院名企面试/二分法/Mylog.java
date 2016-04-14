package CN.EDU.SEU.极客学院名企面试.二分法;

/**
 * 实现一个自己的求对数函数
 * Created by LCN on 2016/4/14.
 */
public class Mylog {

    //logab
    public double logCommon(double a, double b) {
        return Math.log(b) / Math.log(a);
    }


    public static void main(String[] args) {
        System.out.println(Math.log(10));  //ln
        System.out.println(Math.log10(100)); //log10
        System.out.println(Math.log1p(10));  //ln(1+x)
    }
}
