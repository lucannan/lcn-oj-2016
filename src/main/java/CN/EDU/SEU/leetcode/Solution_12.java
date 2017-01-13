package CN.EDU.SEU.leetcode;

import java.util.TreeMap;

public class Solution_12 {
public String intToRoman(int num) {
	TreeMap<Integer, String> intToRoman = new TreeMap<>();
    intToRoman.put(1,"I");
    intToRoman.put(5,"V");
    intToRoman.put(10,"X");
    intToRoman.put(50,"L");
    intToRoman.put(100,"C");
    intToRoman.put(500,"D");
    intToRoman.put(1000,"M");
    //System.out.println(num);
    
    // Base cases
    if (num <=0)
        return "";
    if (intToRoman.containsKey(num))
        return intToRoman.get(num);

    StringBuilder roman = new StringBuilder();
    while(num > 0) {
        Integer l = intToRoman.floorKey(num);
        Integer r = intToRoman.ceilingKey(num);

        if (r == null)
            r = l;
        if (l == null)
            l = r;
        Integer pl = intToRoman.floorKey(l - 1);
        if (pl == null) {
            System.out.println(l + ": " + pl);
            pl = l; // Get the previous number to the lowest.
        }
        // Logic is that - shouldn't repeat the same symbols more 3 times. e.g 4 --> "IV" and "IIII"
        if (num >= 4 * l)
        {
            roman.append(intToRoman.get(l)).append(intToRoman.get(r));
            num -= (r-l);
        } else if (num - l*(num/l) >= 4 * pl) {
            roman.append(intToRoman.get(pl)).append(intToRoman.get(r));
            num -= (r-pl);
        } else {
            roman.append(intToRoman.get(l));
            num -= l;
        }
    }
    return roman.toString();
}
}
