package CN.EDU.SEU.排序算法;

/**
 * Created by LCN on 2016/3/20.
 */

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度
 * 堆的存储表示是顺序的。因为堆所对应的二叉树为完全二叉树，而完全二叉树通常采用顺序存储方式。
 * 当想得到一个序列中第k个最小的元素之前的部分排序序列，最好采用堆排序。
 * 因为堆排序的时间复杂度是O(n+klog2n)，若k≤n/log2n，则可得到的时间复杂度为O(n)。
 * 算法稳定性
 * 堆排序是一种不稳定的排序方法。
 * 因为在堆的调整过程中，关键字进行比较和交换所走的是该结点到叶子结点的一条路径，
 * 因此对于相同的关键字就可能出现排在后面的关键字被交换到前面来的情况。
 */

public class Heap {
    public static void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

    public static void heapSort(int[] list) {
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.length - 1);
        }

        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i);
        }
    }


    /*****************************************************/
    public static void sink(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n) {
                if (a[j] < a[j + 1]) j++;
            }
            if (a[k] >= a[j]) break;

            int temp = a[k];
            a[k] = a[j];
            a[j] = temp;

            k = j;
        }
    }

    public static void sort(int[] a) {
        int[] b = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            b[i + 1] = a[i];
        }

        int n = b.length - 1;
        for (int k = n / 2; k >= 1; k--) {
            sink(b, k, n);
        }

        while (n > 1) {
            //交换
            int temp = b[n];
            b[n] = b[1];
            b[1] = temp;
            n--;
            sink(b, 1, n);
        }


        for (int i = 0; i < a.length; i++) {
            a[i] = b[i + 1];
        }
    }


    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 6, 4, 3, 7, 5,
                1, 3, 7, 0, 12, 32, 6565, 78, 43,
                32, 989, 65, 43, 323, 3443, 67768,
                979, 9, 5, 31,7,432323};
//        Heap.heapSort(a);
        Heap.sort(a);

        System.out.println(Arrays.toString(a));

    }
}
