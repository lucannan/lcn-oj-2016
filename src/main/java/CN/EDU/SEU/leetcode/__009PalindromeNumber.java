package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/4/7.
 */
public class __009PalindromeNumber {

    public boolean isPalindrome(int x){
        Integer integer = x;
        String str = integer.toString();
        String inverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(inverseStr);
    }

    public static boolean isPalindrome2(int x){
        if(x<0) return false;
        if(x == 0) return true;
        int div = 1;
        while(x/div>=10){
            div *=10;
        }
        while(x>0){
            int r = x%10;
            int l = x/div;
            if(l!= r) return false;
            x = (x%div)/10;
            div/=100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(3113));
    }
}
