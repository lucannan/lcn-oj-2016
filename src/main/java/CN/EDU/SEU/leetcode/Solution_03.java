package CN.EDU.SEU.leetcode;

public class Solution_03 {
	public int lengthOfLongestSubString(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int res = 1;
		boolean[] exist = new boolean[256];
		int start = 0;
		
		for(int i = 0; i< s.length(); i++){
			char ch = s.charAt(i);
			if(exist[ch]){
				res = Math.max(res,  i - start);
				for (int k = start;k < i;k++){
					if(s.charAt(k) == ch){
						start = k + 1;
						break;
					}
					exist[s.charAt(k)] = false;
				}
			}else{
				exist[ch] = true;
			}
		}
		
		return res;
	}

}
