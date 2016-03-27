package CN.EDU.SEU.程序员面试经典.递归和动态规划;

import org.junit.Test;

import java.util.*;

/**
 * P222
 * 有一个机器人坐在X,Y网格的左上角，只能向右或者向下移动。机器人从（0,0）到 (X,Y)有多少种走法
 * 进阶
 * 如果其中有一些点是禁区，机器人不能进入。设计一种算法，找出一条路径
 * Created by LCN on 2016/3/27.
 */
public class __9_2GetPath {

    /**
     * 判断（x,y）节点是否能够行走
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean isFree(int x, int y) {
        return true;
    }

    /**
     * 不使用动态规划
     *
     * @param x
     * @param y
     * @param path
     * @return
     */
    public static boolean getPath(int x, int y, List<MyPoint> path) {
        MyPoint p = new MyPoint(x, y);
        path.add(p);
        if (x == 0 && y == 0) {
            return true;
        }

        boolean success = false;
        if (x >= 1 && isFree(x - 1, y)) {
            success = getPath(x - 1, y, path);
        }

        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPath(x, y - 1, path);
        }
        if (!success) {
            path.remove(p);
        }
        return true;
    }


    /**
     * 使用动态规划
     *
     * @param x
     * @param y
     * @param path
     * @param cache
     * @return
     */
    public static boolean getPathDp(int x, int y, List<MyPoint> path, HashMap<MyPoint, Boolean> cache) {

        MyPoint p = new MyPoint(x, y);
        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        path.add(p);
        if (x == 0 && y == 0) {
            return true;
        }
        boolean success = false;

        if (x >= 1 && isFree(x - 1, y)) {
            success = getPathDp(x - 1, y, path, cache);
        }

        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPathDp(x, y - 1, path, cache);
        }

        if (!success) {
            path.remove(p);
        }
        cache.put(p, success);

        return success;
    }

    public static void main(String[] args) {
        List<MyPoint> path = new ArrayList<MyPoint>();
        boolean success = getPath(5, 5, path);

        System.out.println(success);
        for (MyPoint p : path) {
            System.out.println(p);
        }
    }


    @Test
    public void testGetPathDp() {
        List<MyPoint> path = new ArrayList<MyPoint>();
        HashMap<MyPoint, Boolean> map = new HashMap<MyPoint, Boolean>();
        boolean success = getPathDp(5, 5, path, map);
        System.out.println(success);

        for (MyPoint p : path) {
            System.out.println(p);
        }

    }
}

class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[x = " + x + ", y = " + y + "]";
    }
}