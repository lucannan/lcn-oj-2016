package CN.EDU.SEU.数据结构与算法分析.算法设计技巧;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * 分治算法解决最近点的问题
 * Created by LCN on 2016/4/7.
 */
public class DevideAndConquer {
    public static Point[] closestPoint(Point[] s) {
        Point[] result = new Point[2];
        double dmin = Double.POSITIVE_INFINITY;
        double tmpmin = 0;
        if (s.length <= 20) {
            for (int i = 0; i < s.length; i++) {
                for (int j = i + 1; j < s.length; j++) {
                    tmpmin = Math.sqrt(Math.pow(s[i].getX() - s[j].getX(), 2) + Math.pow(s[i].getY() - s[j].getY(), 2));
                    if (tmpmin < dmin) {
                        dmin = tmpmin;
                        result[0] = s[i];
                        result[1] = s[j];
                    }
                }
            }
            return result;
        }

        int minX = (int) Double.POSITIVE_INFINITY;
        int maxX = (int) Double.NEGATIVE_INFINITY;

        for (int i = 0; i < s.length; i++) {
            if (s[i].getX() < minX) {
                minX = s[i].getX();
            }

            if (s[i].getX() > maxX) {
                maxX = s[i].getX();
            }
        }
        int midX = (minX + maxX) / 2;

        ArrayList<Point> t1 = new ArrayList<>();
        ArrayList<Point> t2 = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            if (s[i].getX() <= midX)
                t1.add(s[i]);
            if (s[i].getX() > midX) {
                t2.add(s[i]);
            }
        }

        Point[] s1 = new Point[t1.size()];
        Point[] s2 = new Point[t2.size()];

        t1.toArray(s1);
        t2.toArray(s2);

        mergeSort(s1, "x");
        mergeSort(s2, "x");

        Point[] result1 = new Point[2];
        result1 = closestPoint(s1);

        Point[] result2 = new Point[2];
        result2 = closestPoint(s2);


        double d1 = Math.sqrt(Math.min(
                Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2)
                ,
                Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2)
        ));


        if (Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2) <
                Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2))
            result = result1;
        else
            result = result2;

        /**
         * 7.在S1、S2中收集距离中线小于d1的点，分别存放于两个表中
         */
        ArrayList<Point> t3 = new ArrayList<>();
        ArrayList<Point> t4 = new ArrayList<>();

        for (int i = 0; i < s1.length; i++) {
            if (midX - s[i].getX() < d1) {
                t3.add(s1[i]);
            }
        }

        for (int i = 0; i < s2.length; i++) {
            if (s2[i].getX() - midX < d1) {
                t4.add(s2[i]);
            }
        }

        /**
         * 8.分别将表T3、T4转换为数组类型的S3、S4，并将其分别按Y坐标升序排列
         */
        Point[] s3 = new Point[t3.size()];
        Point[] s4 = new Point[t4.size()];

        t3.toArray(s3);
        t4.toArray(s4);

        mergeSort(s3, "y");
        mergeSort(s3, "y");

        double d = Double.POSITIVE_INFINITY;
        for (int i = 0; i < s3.length -1; i++) {
            for (int j = 0; j < s4.length -1; j++) {
                if (Math.abs(s3[i].getY() - s[4].getY()) < d1) {
                    double tmp = Math.sqrt(Math.pow(s3[i].getX() - s[4].getX(), 2) +
                            Math.pow(s3[i].getY() - s4[i].getY(), 2));
                    if (tmp < d1) {
                        d = tmp;
                        result[0] = s3[i];
                        result[1] = s4[j];
                    }
                }
            }
        }

        return result;
    }


    public static void mergeSort(Point[] a, String property) {
        Point[] tempArray = new Point[a.length];
        mergeSort(a, tempArray, 0, a.length - 1, property);

    }

    public static void mergeSort(Point[] a, Point[] tempArray, int left, int right, String property) {
        if (left < right) {
            int center = (left + right) >> 1;
            mergeSort(a, tempArray, left, center, property);
            mergeSort(a, tempArray, center + 1, right, property);
            merge(a, tempArray, left, center + 1, right, property);
        }
    }

    public static void merge(Point[] a, Point[] tempArray, int leftPos, int rightPos, int rightEnd, String property) {
        int leftEnd = rightPos - 1;
        int numOfElement = rightEnd - leftPos + 1;
        int tempPos = leftPos;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (property.equals("x")) {
                if (a[leftPos].getX() <= a[rightPos].getX())
                    tempArray[tempPos++] = a[leftPos++];
                else
                    tempArray[tempPos++] = a[rightPos++];
            } else if (property.equals("y")) {
                if (a[leftPos].getY() <= a[rightPos].getY())
                    tempArray[tempPos++] = a[leftPos++];
                else
                    tempArray[tempPos++] = a[rightPos++];
            } else {
                throw new RuntimeException();
            }
        }
        while (leftPos <= leftEnd)
            tempArray[tempPos++] = a[leftPos++];
        while (rightPos <= rightEnd)
            tempArray[tempPos++] = a[rightPos++];
    }


    public static void main(String[] args) {
        Set<Point> testData = new HashSet<>();

        Random random = new Random();
        int x = 0;
        int y = 0;

        for (int i = 0; i < 500; i++) {
            x = random.nextInt(50);
            y = random.nextInt(50);
            System.out.println("x:" + x + "  y:" + y);
            testData.add(new Point(x, y));
        }

        Point[] S = new Point[testData.size()];
        S = (Point[]) testData.toArray(S);

        for (int i = 0; i < S.length; i++) {
            System.out.println("(" + S[i].getX() + ", " + S[i].getY() + ")");
        }

        System.out.println(testData.size());

        Point[] result = new Point[2];

        result = closestPoint(S);

        System.out.println("最近的两点分别是(" + result[0].getX() + ", " + result[0].getY()
                + ") 和 (" + result[1].getX() + ", " + result[1].getY() + "), 最近距离为："
                + Math.sqrt(Math.pow(result[0].getX() - result[1].getX(), 2) + Math.pow(result[0].getY() - result[1].getY(), 2)));

    }

}


class Point implements Cloneable, Comparable<Point> {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.getX() && y == o.getY()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
