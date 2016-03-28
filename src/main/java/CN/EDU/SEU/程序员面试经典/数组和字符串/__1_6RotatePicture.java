package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 给定一幅有N*N矩阵表示的图像，其中每个像素的大小为4个字节
 * 编写一个方法，将图像旋转90度。不占用额外的内存空间。
 * Created by LCN on 2016/3/28.
 */
public class __1_6RotatePicture {

    public static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                //左到上
                matrix[first][i] = matrix[last - offset][first];
                //下到左
                matrix[last - offset][first] = matrix[last][last - offset];
                //右到下
                matrix[last][last - offset] = matrix[i][last];
                //上到右
                matrix[i][last] = top;
            }
        }
    }
}
