package CN.EDU.SEU.程序员面试经典.递归和动态规划;

/**
 * 编写函数 实现许多图片编辑软件都支持的“填充颜色”功能。给个一个屏幕（以二维数组表示,元素为颜色值）
 * 一个点和一个新的颜色值，将新的颜色值填入到这个点的周围区域
 * Created by LCN on 2016/3/27.
 */

enum Color {
    Black, White, Red, Yello, Green
}

public class __9_7PaintFill {

    public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
            return false;

        if (screen[y][x] == ocolor) {
            screen[y][x] = ncolor;
            paintFill(screen, x - 1, y, ocolor, ncolor);//左
            paintFill(screen, x, y - 1, ocolor, ncolor);//上
            paintFill(screen, x + 1, y, ocolor, ncolor);//右
            paintFill(screen, x, y + 1, ocolor, ncolor);//下
        }
        return true;
    }
}
