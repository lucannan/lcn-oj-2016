package CN.EDU.SEU.leetcode;

public class Solution_125 {
	public static boolean isPalindrome(String s) {
        if(s == null){
        	return false;
        }
      
        char[] strChars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: strChars){
        	if(c >= '0' && c <= '9' ){
        		sb.append(c);
        	}
        	if(c >= 'A' && c <= 'Z'){
        		sb.append((char)((int)c +32));
        	}
        	
        	if(c >= 'a' && c <= 'z'){
        		sb.append(c);
        	}
        }
        return sb.toString().equals(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		isPalindrome("aA");
	}
        
}
