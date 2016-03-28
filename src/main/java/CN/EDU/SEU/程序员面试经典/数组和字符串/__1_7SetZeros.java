package CN.EDU.SEU.程序员面试经典.数组和字符串;

/**
 * 编写一个算法，如果M*N矩阵中某个元素为0,则将它所在的列和行删除
 * Created by LCN on 2016/3/28.
 */
public class __1_7SetZeros {


    public static void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
