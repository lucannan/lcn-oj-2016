package CN.EDU.SEU.leetcode;

import java.util.*;
public class Solution_383 {
	 public boolean canConstruct(String ransomNote, String magazine) {
	        if(ransomNote == null || magazine == null) return false;
	        
	        HashMap<String, Integer> mag_hash = new HashMap();
	        for(int i=0;i<magazine.length();i++){
	            String c = String.valueOf(magazine.charAt(i));
	            if(mag_hash.containsKey(c)){
	                mag_hash.put(c,mag_hash.get(c) +1);
	            }else{
	                mag_hash.put(c, 1);
	            }            
	        }
	        
	        for(int j=0; j<ransomNote.length();j++){
	            String c = String.valueOf(ransomNote.charAt(j));
	            if(!mag_hash.containsKey(c)) return false;
	            
	            int val = mag_hash.get(c);
	            if(val <= 0) return false;
	            mag_hash.put(c, val-1);
	        }
	        return true;
	    }
}
