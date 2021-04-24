package middle;

import javax.swing.*;

public class exist79 {
    public static void main(String[] args) {
        exist79 t = new exist79();
        t.test();
    }

    private void test() {
        char[][] eg = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] egW = {"ABCCED", "SEE", "ABCB"};
        for (String w : egW) {
            System.out.println(exist(eg, w));
        }
    }

    boolean[][] used;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        if (n == 0) {
            return false;
        }
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (dp(board, word, 0, i, j)) {
                        return true;
                    } else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean dp(char[][] board, String word, int start, int row, int column) {
        if (start + 1 == word.length()) {
            return true;
        }
        char next = word.charAt(start + 1);
        //下，标记走过的路用到回溯
        if (row + 1 < m && !used[row + 1][column] && board[row + 1][column] == next) {
            used[row + 1][column] = true;
            if (dp(board, word, start + 1, row + 1, column)) {
                return true;
            }
            used[row + 1][column] = false;
        }
        //上
        if (row - 1 > -1 && !used[row - 1][column] && board[row - 1][column] == next) {
            used[row - 1][column] = true;
            if (dp(board, word, start + 1, row - 1, column)) {
                return true;
            }
            used[row - 1][column] = false;
        }
        //右
        if (column + 1 < n && !used[row][column + 1] && board[row][column + 1] == next) {
            used[row][column + 1] = true;
            if (dp(board, word, start + 1, row, column + 1)) {
                return true;
            }
            used[row][column + 1] = false;
        }
        //左
        if (column - 1 > -1 && !used[row][column - 1] && board[row][column - 1] == next) {
            used[row][column - 1] = true;
            if (dp(board, word, start + 1, row, column - 1)) {
                return true;
            }
            used[row][column - 1] = false;
        }
        return false;
    }
}
