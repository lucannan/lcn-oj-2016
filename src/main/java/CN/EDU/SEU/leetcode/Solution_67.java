package CN.EDU.SEU.leetcode;

public class Solution_67 {
	public static String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		int maxLen = Math.max(aLen, bLen);
		char[] arrSum = new char[maxLen + 1];
		for (int i = 0; i <= maxLen; i++) {
			arrSum[i] = '0';
		}
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		for (int i = 0; i < maxLen; i++) {
			if (i == maxLen) {
				break;
			}

			int numA = 0;
			int numB = 0;

			if (i < aLen)
				numA = aArr[aLen - 1 - i] - '0';
			if (i < bLen)
				numB = bArr[bLen - 1 - i] - '0';

			int curSum = numA + numB + (arrSum[i] - '0');
			if (curSum >= 2) {
				arrSum[i] = (char) (curSum % 2 + 48);
				arrSum[maxLen - i - 2] = '1';
			} else {
				arrSum[maxLen - i - 1] = (char) (curSum + 48);
			}
			
		}
		
		if(arrSum[0] == '0'){
			arrSum[0] = '\0';
		}
		return String.valueOf(arrSum);
	}

	public static void main(String[] args) {
		System.out.println(addBinary("0", "0"));
		
		System.out.println(String.valueOf(new char[] {'\0'}));
		
		
	}
}
