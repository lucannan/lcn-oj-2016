package CN.EDU.SEU.动态规划;


import java.util.Scanner;

/**
 * 01背包之金矿模型
 * Created by LCN on 2016/4/1.
 */
public class Beibao01_Gold {


    public static void main(String[] args) {
//        GoldHelper goldHelper = new GoldHelper(10000,10);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int peopleNum = scanner.nextInt();
            int mineNum = scanner.nextInt();
            GoldHelper goldHelper = new GoldHelper(peopleNum, mineNum);
            for (int i = 1; i < mineNum + 1; i++) {
                goldHelper.peopleNeeded[i] = scanner.nextInt();
                goldHelper.gold[i] = scanner.nextInt();
            }
            System.out.println(goldHelper.getMaxGold(peopleNum, mineNum));

        }

    }

}

class GoldHelper {

    public int[] peopleNeeded; //每座金矿需要的人数
    public int[] gold;      //每座金矿挖出来的金子数
    int goldmMineNumebr; //金矿数
    int peopleNumber; //用于挖金子的人数
    int[][] cacheData;//用于存放第i个人挖前j个金矿得到的最大的金子个数，等于-1表示未知

    public GoldHelper(int peopleNumber, int goldmMineNumebr) {
        this.goldmMineNumebr = goldmMineNumebr;
        this.peopleNumber = peopleNumber;
        gold = new int[goldmMineNumebr + 1];
        peopleNeeded = new int[goldmMineNumebr + 1];
        cacheData = new int[peopleNumber + 1][goldmMineNumebr + 1];
        for (int i = 1; i < peopleNumber + 1; i++) {
            for (int j = 1; j < goldmMineNumebr + 1; j++) {
                cacheData[i][j] = -1;
            }
        }
    }

    public int getMaxGold(int people, int mineNum) {
        int retMaxgold; //返回的最大金子数
        //如果这个问题曾经计算过  [对应动态规划中的“做备忘录”]
        if (cacheData[people][mineNum] != -1) {
            //获得保存起来的值
            retMaxgold = cacheData[people][mineNum];
        } else if (mineNum == 0) {//如果仅有一个金矿时 [对应动态规划中的“边界”]
            //当给出的人数足够开采这座金矿
            if (people >= peopleNeeded[mineNum]) {
                //得到的最大值就是这座金矿的金子数
                retMaxgold = gold[mineNum];
            } else {
                //得到的最大值为0个金子
                retMaxgold = 0;
            }
        } else if (people >= peopleNeeded[mineNum]) {//如果给出的人够开采这座金矿 [对应动态规划中的“最优子结构”]
            //考虑开采与不开采两种情况，取最大值
            retMaxgold = Math.max(getMaxGold(people - peopleNeeded[mineNum], mineNum - 1) +
                    gold[mineNum], getMaxGold(people, mineNum - 1));
        } else {//否则给出的人不够开采这座金矿 [对应动态规划中的“最优子结构”]
            //仅考虑不开采的情况
            retMaxgold = getMaxGold(people, mineNum - 1);
        }
        //做备忘录
        cacheData[people][mineNum] = retMaxgold;
        return retMaxgold;
    }


}
