package CN.EDU.SEU.程序员面试经典.位操作;

/**
 * 给定两个32位的整数N与M，以及表示比特位置的i和j。编写一个方法，将M插入N，使得M从N的j位开始到i位结束
 * Created by LCN on 2016/3/27.
 */
public class __5_1UpdateBit {


    public static int updateBits(int n, int m, int i, int j) {

        //创建掩码  用于清除n中i到j的位
        int allOnes = ~0;

        int left = allOnes << (j + 1);

        int right = (1 << i) - 1;

        int mask = left | right;

        //清除n中j到i的位  将m放进去
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }
}
