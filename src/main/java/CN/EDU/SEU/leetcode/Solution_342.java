package CN.EDU.SEU.leetcode;

public class Solution_342 {
	public static boolean isPowerOfFour(int num) {
	    return Integer.toString(num, 4).matches("10*");
	}
	
	
	   public static boolean isPowerOfFour2(int num) {
	        int x = (int)Math.sqrt(num);
	        //1073741824 is 4^15,  4^16 is bigger than int 
	        return(num > 0 && 1073741824 % num == 0 && x*x == num);
	    }
	
	

	
	public static void main(String[] args) {
		System.out.println(Integer.toString(1,4));
		System.out.println("100".matches("10*"));
		
		System.out.println(isPowerOfFour(1));
	}
}
