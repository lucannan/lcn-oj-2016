package CN.EDU.SEU.程序员面试经典.递归和动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个算法，打印八皇后在8*8棋盘上面的各种摆法，其中每个皇后都不同行，不同列
 * 也不对角。对角指的所有的对角线
 * Created by LCN on 2016/3/27.
 */
public class __9_9PlaceQueens {

    public static final int GRID_SIZE = 8;

    /**
     * 检查row1和columns是否可以排放皇后
     * 检查其他的皇后是否处于同一列或者对角线上，不必检查是否在同一行上，
     * 在调用placeQueen时，一次只会摆放一个皇后，这一行是空的
     * <p>
     * 因为每一行只需要存放一个皇后，所以不需要将棋盘存储为8*8的矩阵
     * 只需要一个一维数组   column[r] = c  表示有个皇后位于r杭c列
     *
     * @param columns
     * @param row1
     * @param column1
     * @return
     */
    public static boolean checkVaild(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            /**
             * 检查同一列有没有其他皇后
             */
            if (column2 == column1)
                return false;
            /**
             * 检查对角线，如果两列的距离等于两行的距离，就表示两个皇后在同一个对角上面
             */
            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance)
                return false;
        }
        return true;
    }

    public static void placeQueen(int row, Integer[] columns, List<Integer[]> result) {
        if (row == GRID_SIZE) {
            result.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkVaild(columns, row, col)) {
                    columns[row] = col;
                    placeQueen(row + 1, columns, result);
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] columns = new Integer[GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = 0;
        }

        List<Integer[]> result = new ArrayList<Integer[]>();

        placeQueen(0, columns, result);

        System.out.println(result.size());

        for (Integer[] integers : result) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }


}
