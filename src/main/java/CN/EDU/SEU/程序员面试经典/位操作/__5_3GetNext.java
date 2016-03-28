package CN.EDU.SEU.程序员面试经典.位操作;

/**
 * 给定一个正整数，找出与其
 * Created by LCN on 2016/3/27.
 */
public class __5_3GetNext {

    public static int getNext(int n) {
        //计算c0和c1
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        //错误情况 若n==111100000,那么就没有更大的数字了
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        //最右边 非拖尾的0的位置
        int p = c0 + c1;

        n |= (1 << p);//翻转最右边，非拖尾的0
        n &= ~((1 << p) - 1);  //将p右边的所有位清零
        n |= (1 << (c1 - 1)) - 1;//在右方插入(c1-1)个1
        return n;
    }


    public static int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1;
        n &= ((~0) << (p + 1));

        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);
        return n;
    }


//    public static int getNextArith(int n ){
////        return n +(1<<c0)
//    }
}
