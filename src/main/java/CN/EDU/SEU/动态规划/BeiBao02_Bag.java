package CN.EDU.SEU.动态规划;

import java.util.ArrayList;

/**
 * Created by LCN on 2016/4/1.
 */
public class BeiBao02_Bag {
}

class Knapsnack {
    //背包重量
    private int weight;
    //背包物品价值
    private int value;

    public Knapsnack(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Knapsnack{" +
                "weight=" + weight +
                ", val=" + value +
                '}';
    }
}


class KnapsackProblem {
    //指定背包
    private Knapsnack[] bags;
    //总重量
    private int totalWeight;
    //给定背包的数量
    private int n;
    /**
     * 前 n 个背包，总承重为 totalWeight 的最优值矩阵
     */
    private int[][] bestValues;

    /**
     * 前 n 个背包，总承重为 totalWeight 的最优值
     */
    private int bestValue;

    /**
     * 前 n 个背包，总承重为 totalWeight 的最优解的物品组成
     */
    private ArrayList<Knapsnack> bestSolution;

    public KnapsackProblem(Knapsnack[] bags, int totalWeight) {
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;

        if (bestValues == null) {
            bestValues = new int[n + 1][totalWeight + 1];
        }
    }


    public void solve() {
        System.out.println("给定背包");
        for (Knapsnack b : bags) {
            System.out.println(b);
        }
        System.out.println("总承重" + totalWeight);

        for (int i = 0; i <= totalWeight; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    bestValues[i][j] = 0;
                }
            }
        }

    }
}
