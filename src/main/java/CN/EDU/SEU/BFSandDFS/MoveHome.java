package CN.EDU.SEU.BFSandDFS;

import java.util.Scanner;

/**
 * 搬家问题
 * Created by LCN on 2016/4/5.
 */
public class MoveHome {
    public char[][] matrix = new char[3][3];
    public void dfs(int i, int j, char[][] matrix,Boolean[] success,int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        if (cache[i][j] == 1){
            return;
        }

        cache[i][j] = 1;
        if (matrix[i][j] == 'E') {
            success[0] = true;
            return;
        }
        if (matrix[i][j] == '#') {
            return;
        }

        dfs(i + 1, j, matrix, success,cache);
        dfs(i - 1, j, matrix, success,cache);
        dfs(i, j + 1, matrix, success,cache);
        dfs(i, j - 1, matrix, success,cache);
    }

    public static void main(String[] args) {
        MoveHome home = new MoveHome();
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    home.matrix[i][j] = scanner.nextLine().charAt(0);
                }
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (home.matrix[i][j] == 'B') {
                        x = i;
                        y = j;
                    }
                }
            }
            Boolean[] success = new Boolean[1];
            success[0] =false;
            int[][]cache ={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
            home.dfs(x, y, home.matrix, success,cache);
            if (success[0]) {
                System.out.println("success");
            } else {
                System.out.println("failure");
            }
        }
    }
}


