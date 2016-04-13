package CN.EDU.SEU.大话数据结构.递归;

import org.junit.Test;

/**
 * 简单递归  monkey eat fruit
 * 极客学院
 * Created by LCN on 2016/4/13.
 */
public class MonkeyEatFruit {
    //递推算法
    public int eat01(int n) {
        int a = 1;
        for (int i = 2; i <= n; i++) {
            a = 2 * a + 1;
        }
        return a;
    }

    //递归算法
    public int eat02(int n) {
        if (n == 1) {
            return 1;
        }

        return 2 * eat02(n - 1)  + 2;
    }

    public static void main(String[] args) {
//        System.out.println(eat01(10));
    }

    @Test
    public void test01() {
        int n = 10;
        int num = eat01(n);

    }

    @Test
    public void test02(){
        int n = 10;
        int num = eat02(n);
        System.out.println(num);
    }
}
