package CN.EDU.SEU.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 二维数组中的查找
 * Created by LCN on 2016/4/18.
 */
public class Test03 {

    public static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0;
        int col = columns - 1;

        while (row >= 0 && row < rows && col >= 0 && col < columns) {
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                col--;
            } else if (matrix[row][col] < number) {
                row++;
            }
        }
        return false;
    }

    @Test
    public void test01() {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Assert.assertFalse(find(matrix,7));
        System.out.println(find(matrix, 7)); // 要查找的数在数组中
        System.out.println(find(matrix, 5)); // 要查找的数不在数组中
        System.out.println(find(matrix, 1)); // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 15)); // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 0)); // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 16)); // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16)); // 健壮性测试，输入空指针
    }

}
