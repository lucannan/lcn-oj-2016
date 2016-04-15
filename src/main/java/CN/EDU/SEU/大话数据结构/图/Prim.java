package CN.EDU.SEU.大话数据结构.图;

/**
 * Created by LCN on 2016/4/15.
 */
public class Prim {
    static int MAX = Integer.MAX_VALUE;

    public static void prim(int[][] graph, int n) {

        char[] c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'E', 'F'};
        int[] lowcost = new int[n];
        int[] mst = new int[n];
        int i, j, min, minid, sum = 0;

        for (i = 1; i < n; i++) {
            lowcost[i] = graph[0][i];
            mst[i] = 0;
        }

        for (i = 1; i < n; i++) {

            min = MAX;
            minid = 0;
            for (j = 1; j < n; j++) {
                if (lowcost[j] < min && lowcost[j] != 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
            System.out.println(c[mst[minid]] + "到" + c[minid] + " 权值：" + min);

            sum += min;
            lowcost[minid] = 0;

            for (j = 1; j < n; j++) {
                if (graph[minid][j] < lowcost[j]) {
                    lowcost[j] = graph[minid][j];
                    mst[j] = minid;
                }
            }
        }

        System.out.println("sum:" + sum);

    }


    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX},
                {10, 0, 18, MAX, MAX, MAX, 16, MAX, 12},
                {MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8},
                {MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21},
                {MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX},
                {11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX},
                {MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX},
                {MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX},
                {MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0}
        };
        prim(map, map.length);
    }
}
