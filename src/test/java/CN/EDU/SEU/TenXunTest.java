package CN.EDU.SEU;

/**
 * Created by LCN on 2016/4/2.
 */
public class TenXunTest {

    public static int dfs(int i, int j, int[][] arr, int[][] cacheData) {
        if (i == arr[0].length) {
            return Integer.MIN_VALUE;
        }
        if (j == arr.length) {
            return Integer.MIN_VALUE;
        }
        if (i == arr[0].length - 1 && j == arr.length - 1) {
            return arr[i][j];
        }
        if (cacheData[i][j] != -1){
            return cacheData[i][j];
        }

        int retLeft = dfs(i + 1, j, arr,cacheData);//右
        int retRight = dfs(i, j + 1, arr,cacheData);  //下

        if (retLeft < retRight) {
            cacheData[i][j] = arr[i][j] + retRight;
            return cacheData[i][j];
        } else {
            cacheData[i][j] = arr[i][j] + retLeft;
            return cacheData[i][j];
        }
    }

    public static void main(String[] args) {
        int[][] arrdata = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, -1}};
        int[][] arrdata2 = {{0, 0, 3, 0}, {0, 0, 3, 4}, {0, 1, 1, 0}, {0, 0, 0, 4}};
        int[][] cacheData = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cacheData[i][j] = -1;
            }
        }


        System.out.println(dfs(0,0,arrdata,cacheData));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cacheData[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0,arrdata2,cacheData));
    }
}
