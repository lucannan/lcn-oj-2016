package CN.EDU.SEU.leetcode;

public class Solution_13 {
	public int romanToInt(String s) {
        String roman = "IVXLCDM";
        int[] num = {1,5,10,50,100,500,1000};
        int prevIdx = roman.indexOf(s.charAt(0));
        int result = num[prevIdx];
        for (int i = 1; i < s.length(); i++) {
            int curIdx = roman.indexOf(s.charAt(i));
            if (prevIdx < curIdx) {
                result += (num[curIdx] - 2*num[prevIdx]);
            } else {
                result += num[curIdx];
            }
            prevIdx = curIdx;
        }
        return result;
    }
}
