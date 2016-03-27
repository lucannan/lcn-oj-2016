package CN.EDU.SEU.排序算法;

/**
 * Created by LCN on 2016/3/21.
 */


/**
 * 时间复杂度
   通过上文可知，假设在基数排序中，r为基数，d为位数。则基数排序的时间复杂度为O(d(n+r))。
   我们可以看出，基数排序的效率和初始序列是否有序没有关联。
   空间复杂度
   在基数排序过程中，对于任何位数上的基数进行“装桶”操作时，都需要n+r个临时空间。
   算法稳定性
   在基数排序过程中，每次都是将当前位数上相同数值的元素统一“装桶”，并不需要交换位置。
   所以基数排序是稳定的算法。
 */
public class RadixSort {
    // 获取x这个数的d位数上的数字
    // 比如获取123的1位数，结果返回3
    public int getDigit(int x, int d) {
        int a[] = { 1, 1, 10, 100,1000,10000,100000,1000000,10000000}; // 本实例中的最大数是百位数，所以只要到100就可以了
        return ((x / a[d]) % 10);
    }

    public void radixSort(int[] list, int begin, int end, int digit) {
        final int radix = 10; // 基数
        int i = 0, j = 0;
        int[] count  = new int[radix]; // 存放各个桶的数据统计个数
        int[] bucket = new int[end - begin + 1];

        // 按照从低位到高位的顺序执行排序过程
        for (int d = 1; d <= digit; d++) {

            // 置空各个桶的数据统计
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            // 统计各个桶将要装入的数据个数
            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }

            // count[i]表示第i个桶的右边界索引
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 将数据依次装入桶中
            // 这里要从右向左扫描，保证排序稳定性
            for (i = end; i >= begin; i--) {
                j = getDigit(list[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5
                bucket[count[j] - 1] = list[i]; //放入对应的桶中，count[j]-1是第j个桶的右边界索引
                count[j]--; // 对应桶的装入数据索引减一
            }

            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }

        }

    }

    public int[] sort(int[] list) {
        radixSort(list, 0, list.length - 1, 8);
        return list;
    }

    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 50, 123, 543, 187, 49, 30, 0, 2, 11, 100,155556,111111};
        RadixSort radix = new RadixSort();
        System.out.print("排序前:\t\t");
        radix.printAll(array);
        radix.sort(array);
        System.out.print("排序后:\t\t");
        radix.printAll(array);
    }

}
