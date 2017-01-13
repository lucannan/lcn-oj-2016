package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_20 {
	public static boolean isValid(String s) {
		if(s.compareTo("") == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        
        
        for(char cur: s.toCharArray()) {
            if(cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
                continue;
            } 
            if(stack.isEmpty()) {
                return false;
            }
            
            Character topInStack = stack.pop();
            switch(cur) {
                case ')':
                    if(topInStack != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if(topInStack != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if(topInStack != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        
        return stack.isEmpty();
	}
	
	
	public static void main(String[] args) {
		System.out.println(isValid("[[[{()}]]]"));
	}
}
