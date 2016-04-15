package CN.EDU.SEU.大话数据结构.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 最小生成树算法
 * Created by LCN on 2016/4/15.
 */
public class MiniSpanTree {
    /**
     * 求图最小生成树的PRIM算法
     * 基本思想：假设N=(V,{E})是联通网，TE是N上的最想生成树中的变得集合。算法从U={u0}(u0属于V)，
     * TE={}开始，重复执行下述操作：在所有的u属于U，v属于V-U的边（u，v）属于E中找到一条代价最小
     * 的边（u0，v0）并入集合TE，同事v0并入U，直至U=V为止。此时TE中必有n-1条边，则T=(V,{TE})
     * 为N的最小生成树。
     *
     * @param graph 图
     * @param start 开始节点
     * @param n     图中节点数
     */
    public static void PRIM(int[][] graph, int start, int n) {
        int[][] mins = new int[n][2];//用于保存集合U到V-U之间的最小边和它的值，mins[i][0]值表示到该节点i边的起始节点
        //值为-1表示没有到它的起始点，mins[i][1]值表示到该边的最小值，
        //mins[i][1]=0表示该节点已将在集合U中
        for (int i = 0; i < n; i++) {//初始化mins

            if (i == start) {
                mins[i][0] = -1;
                mins[i][1] = 0;
            } else if (graph[start][i] != -1) {//说明存在（start，i）的边
                mins[i][0] = start;
                mins[i][1] = graph[start][i];
            } else {
                mins[i][0] = -1;
                mins[i][1] = Integer.MAX_VALUE;
            }
//          System.out.println("mins["+i+"][0]="+mins[i][0]+"||mins["+i+"][1]="+mins[i][1]);
        }
        for (int i = 0; i < n - 1; i++) {
            int minV = -1, minW = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {//找到mins中最小值，使用O(n^2)时间

                if (mins[j][1] != 0 && minW > mins[j][1]) {
                    minW = mins[j][1];
                    minV = j;
                }
            }
//          System.out.println("minV="+minV);
            mins[minV][1] = 0;
            System.out.println("最小生成树的第" + i + "条最小边=<" + (mins[minV][0] + 1) + "," + (minV + 1) + ">，权重=" + minW);
            for (int j = 0; j < n; j++) {//更新mins数组
                if (mins[j][1] != 0) {
//                  System.out.println("MINV="+minV+"||tree[minV][j]="+tree[minV][j]);
                    if (graph[minV][j] != -1 && graph[minV][j] < mins[j][1]) {
                        mins[j][0] = minV;
                        mins[j][1] = graph[minV][j];
                    }
                }
            }
        }
    }

    /**
     * 求最小树的Kruskal算法
     * 算法思想：克鲁斯卡尔算法从另一个途径求网中的最小生成树。假设联通网N=(V,{E})，则令
     * 最小生成树的厨师状态为只有n个顶点而无边的非连通图T=(V,{})，途中每个顶点自称一个连通分量。
     * 在E中选择代价最小的边，若该边衣服的顶点落在T中不同的连通分量上，则将此边加入到T中，否则舍去此边
     * 而选择下一条最小的边。以此类推，直至T中所有的顶点都在同一连通分量上为止。
     *
     * @param V 图中的节点集合
     * @param E 图中边的集合
     */
    public static void KRUSKAL(int[] V, Edge[] E) {
        Arrays.sort(E);//将边按照权重w升序排序
        ArrayList<HashSet> sets = new ArrayList<HashSet>();
        for (int i = 0; i < V.length; i++) {
            HashSet set = new HashSet();
            set.add(V[i]);
            sets.add(set);
        }

        System.out.println("++++++++++++++++++++++size=" + sets.size());
        for (int i = 0; i < E.length; i++) {
            int start = E[i].i, end = E[i].j;
            int counti = -1, countj = -2;
            for (int j = 0; j < sets.size(); j++) {
                HashSet set = sets.get(j);
                if (set.contains(start)) {
                    counti = j;
                }

                if (set.contains(end)) {
                    countj = j;
                }
            }
            if (counti < 0 || countj < 0) System.err.println("没有在子树中找到节点，错误");

            if (counti != countj) {
                System.out.println("输出start=" + start + "||end=" + end + "||w=" + E[i].w);
                HashSet setj = sets.get(countj);
                sets.remove(countj);
                HashSet seti = sets.get(counti);
                sets.remove(counti);
                seti.addAll(setj);
                sets.add(seti);
            } else {
                System.out.println("他们在一棵子树中，不能输出start=" + start + "||end=" + end + "||w=" + E[i].w);

            }
        }


    }

    public static void main(String[] args) {
        int[][] tree = {
                {-1, 6, 1, 5, -1, -1},
                {6, -1, 5, -1, 3, -1},
                {1, 5, -1, 5, 6, 4},
                {5, -1, 5, -1, -1, 2},
                {-1, 3, 6, -1, -1, 6},
                {-1, -1, 4, 2, 6, -1}
        };
        MiniSpanTree.PRIM(tree, 0, 6);
        System.out.println("+++++++++++++++++++++++++++++++++");

        int[] V = {1, 2, 3, 4, 5, 6};
        Edge[] E = new Edge[10];
        E[0] = new Edge(1, 2, 6);
        E[1] = new Edge(1, 3, 1);
        E[2] = new Edge(1, 4, 5);
        E[3] = new Edge(2, 3, 5);
        E[4] = new Edge(2, 5, 3);
        E[5] = new Edge(3, 4, 5);
        E[6] = new Edge(3, 5, 6);
        E[7] = new Edge(3, 6, 4);
        E[8] = new Edge(4, 6, 2);
        E[9] = new Edge(5, 6, 6);
        MiniSpanTree.KRUSKAL(V, E);
    }
}
