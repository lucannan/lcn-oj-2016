package CN.EDU.SEU.BFSandDFS;

/**
 * leetcode  130
 * surrounded regions
 * Created by LCN on 2016/4/6.
 */
public class SurroundedRegions_130 {
    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && (board[i][j] == 'O')) {
                    board[i][j] = 'M';
                    dfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    //上下左右
    public static void dfs(int i, int j, char[][] board) {
        //上
        if (i - 1 > 0 && board[i - 1][j] == 'O') {
            board[i - 1][j] = 'M';
            dfs(i - 1, j, board);
        }

        //下
        if (i + 1 < board.length - 1 && board[i + 1][j] == 'O') {
            board[i + 1][j] = 'M';
            dfs(i + 1, j, board);
        }

        //左
        if (j - 1 > 0 && board[i][j - 1] == 'O') {
            board[i][j - 1] = 'M';
            dfs(i, j - 1, board);
        }

        //右
        if (j + 1 < board[i].length - 1 && board[i][j + 1] == 'O') {
            board[i][j + 1] = 'M';
            dfs(i, j + 1, board);
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
