package CN.EDU.SEU;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by LCN on 2016/4/2.
 */
public class TenXunTest {

    public static int dfs(int i, int j, int[][] arr, int[][] cacheData) {
        if (i == arr.length) {
            return Integer.MIN_VALUE;
        }
        if (j == arr[0].length) {
            return Integer.MIN_VALUE;
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j];
        }
        if (cacheData[i][j] != -1) {
            return cacheData[i][j];
        }

        int retRight = dfs(i + 1, j, arr, cacheData);    //右
        int retDown = dfs(i, j + 1, arr, cacheData);     //下

        if (retRight < retDown) {
            cacheData[i][j] = arr[i][j] + retDown;
        } else {
            cacheData[i][j] = arr[i][j] + retRight;
        }
        return cacheData[i][j];
    }

    public static void main(String[] args) {
//        int[][] arrdata = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, -1}, {1, 2, 3, -1}};
////        int[][] arrdata2 = {{0, 0, 3, 0}, {0, 0, 3, 4}, {0, 1, 1, 0}, {0, 0, 0, 4}};
//        int[][] cacheData = new int[5][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                cacheData[i][j] = -1;
//            }
//        }
//        int[][] arrTest = {{1, 3, 4, 5}, {1, 3, 4, 5}, {1, 3, 4, 5}, {1, 3, 4, 5}};
        Queue<String> queue = new ArrayBlockingQueue<String>(2);
        queue.add("hello");
        queue.add("hello");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
//        System.out.println(dfs(0, 0, arrdata, cacheData));
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                cacheData[i][j] = -1;
//            }
//        }
//        System.out.println(dfs(0,0,arrdata2,cacheData));
    }
}
