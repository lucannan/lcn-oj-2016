package CN.EDU.SEU;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LCN on 2016/4/3.
 */
public class TenXunTest2 {

    public static void dfs(int i, int j, int[][] arrData, List<Integer> data,int[] value){
        if (i == arrData[0].length){
            return;
        }
        if (j == arrData.length){
            return;
        }
        if (i == arrData[0].length - 1 && j == arrData.length - 1){
            data.add(value[0] + arrData[i][j]);
            return;
        }
        value[0] = value[0] + arrData[i][j];
        int temp = value[0];
        dfs(i+ 1,j,arrData,data,value);
        value[0] = temp;
        dfs(i,j+1,arrData,data,value);
    }

    public static void main(String[] args) {
        int[][] arrdata = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int[][] arrdata2 = {{0, 0, 3, 0}, {0, 0, 3, 4}, {0, 1, 1, 0}, {0, 0, 0, 4}};
        int[] value = {0};
        List<Integer> data = new ArrayList<>();
        dfs(0,0,arrdata,data,value);

        System.out.println(data.size());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}
