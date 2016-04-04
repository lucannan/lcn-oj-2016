package CN.EDU.SEU.leetcode;

/**
 * Created by LCN on 2016/4/3.
 */
public class __056GenerateMatrix {


    public static int[][] generateMatrix(int n) {
        int number = 1;
        int[][] data = new int[n][n];
        int start = 0;
        int end = n;
        while (start < end) {
            for (int i = start; i < end; i++) {
                data[start][i] = number++;
            }  //right

            for (int i = start + 1; i < end; i++) {
                data[i][end - 1] = number++;
            }  //down

            for (int i = end - 2; i >= start; i--) {
                data[end - 1][i] = number++;
            } //left

            for (int i = end - 2; i > start; i--) {
                data[i][start] = number++;
            }
            start++;
            end--;
        }
        return data;
    }

    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }
}
