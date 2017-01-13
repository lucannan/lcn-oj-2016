package CN.EDU.SEU.leetcode;

import java.util.*;

public class Solution_118 {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> generate(int numRows) {
		
		for (int i = 0; i < numRows; i++) {

			result.add(generateRow(i));
		}
		return result;
	}

	private List<Integer> generateRow(int num) {
		List<Integer> list = new ArrayList<Integer>();
		if (num == 0) {
			list.add(1);
			return list;
		} else {
			list.add(1);
			for (int i = 1; i < num; i++) {

				list.add(result.get(num - 1).get(i - 1) + result.get(num - 1).get(i));

			}
			list.add(1);
		}

		return list;
	}
}
