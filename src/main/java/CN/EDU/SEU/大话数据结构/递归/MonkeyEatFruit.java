package CN.EDU.SEU.大话数据结构.递归;

/**
 * 简单递归  monkey eat fruit
 * 极客学院
 * Created by LCN on 2016/4/13.
 */
public class MonkeyEatFruit {

    public static int eat01(int n){
        int a = 1;
        for (int i = 2; i <= n; i++) {
            a = 2*a + 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(eat01(10));
    }
}
