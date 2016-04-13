package CN.EDU.SEU.极客学院名企面试;

import org.junit.Test;

/**
 * 1+2+3+ ... + 100 的几种算法
 * Created by LCN on 2016/4/13.
 */
public class CommonSum {
    /**
     *递推算法
     */
    public int commonMethod01(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }


    /**
     * 递归算法
     */
    public int commonMethod02(int n){
        if(n==1){
            return 1;
        }else{
            return commonMethod02(n-1)+n;
        }
    }


    /**
     * 等差数列求和公式
     */
    public int commonMethod03(int n){
        return n*(1+n)/2;
    }


    @Test
    public void test(){
        int n=100;
        int sum1=commonMethod01(n);
        int sum2=commonMethod02(n);
        int sum3=commonMethod03(n);
        System.out.println(sum1+" "+sum2+" "+sum3);
    }

}
