package middle;

import tools.GeneralTool;

import java.util.Arrays;
import java.util.List;

public class solve130 {
    public static void main(String[] args) {
        solve130 t = new solve130();
        t.test();
    }

    private void test() {
        String[][] eg = {
                {"XXXXOOXXO", "OOOOXXOOX", "XOXOOXXOX", "OOXXXOOOO", "XOOXXXXXO",
                        "OOXOXOXOX", "OOOXXOXOX", "OOOXOOOXO", "OXOOOXOXO"},
                {"XXXX", "XOOX", "XXOX", "XOXX"},
                {"OXOOOX", "OOXXXO", "XXXXXO", "OOOOXX", "XXOOXO", "OOXXXX"}
        };

        for (String[] e : eg) {
            char[][] bd = GeneralTool.strArr2CharMatrix(e);
            for (char[] b : bd) {
                System.out.println(Arrays.toString(b));
            }
            solve(bd);
            System.out.println();
            for (char[] b : bd) {
                System.out.println(Arrays.toString(b));
            }
            System.out.println();
        }

//        String[][] comp1 = {{"O", "X", "O", "O", "X", "X", "X", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "X", "O", "X"}, {
//                "X", "X", "X", "O", "O", "X", "X", "O", "O", "X", "O", "X", "O", "X", "O", "X", "X", "O", "O", "O"}, {
//                "O", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "O", "O", "O", "X", "X", "X", "X", "O", "X"}, {
//                "X", "X", "O", "O", "O", "X", "X", "O", "O", "O", "X", "X", "X", "O", "O", "X", "O", "X", "X", "O"}, {
//                "O", "X", "O", "X", "X", "X", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "O", "O", "O", "X"}, {
//                "X", "O", "O", "X", "X", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "X", "O", "O", "O", "O"}, {
//                "X", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "X", "O", "O", "X", "O", "O", "O", "O", "X"}, {
//                "X", "O", "O", "O", "X", "X", "X", "X", "X", "O", "X", "O", "X", "X", "X", "X", "O", "O", "O", "X"}, {
//                "X", "O", "O", "X", "X", "X", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "X"}, {
//                "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "O", "X", "O"}, {
//                "X", "O", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "X", "X", "O", "O", "O"}, {
//                "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X", "O"}, {
//                "X", "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "X", "O", "O", "X"}, {
//                "O", "O", "O", "O", "X", "O", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O"}, {
//                "O", "X", "X", "O", "O", "O", "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "X", "O", "X", "O"}, {
//                "X", "O", "X", "X", "X", "X", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X"}, {
//                "X", "O", "O", "O", "X", "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "X", "X", "X"}, {
//                "O", "O", "X", "O", "O", "O", "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "O", "O"}, {
//                "O", "O", "X", "O", "O", "O", "O", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X", "X"}, {
//                "X", "O", "O", "O", "X", "O", "X", "X", "X", "O", "O", "X", "O", "X", "O", "X", "X", "O", "O", "O"
//        }};
//
//        String[][] comp2 = {{"O", "X", "O", "O", "X", "X", "X", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "X", "O", "X"}, {
//                "X", "X", "X", "O", "O", "X", "X", "O", "O", "X", "O", "X", "O", "X", "O", "X", "X", "O", "O", "O"}, {
//                "O", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "O", "O", "O", "X", "X", "X", "X", "O", "X"}, {
//                "X", "X", "O", "O", "O", "X", "X", "O", "O", "O", "X", "X", "X", "O", "O", "X", "O", "X", "X", "O"}, {
//                "O", "X", "O", "X", "X", "X", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "O", "O", "O", "X"}, {
//                "X", "O", "O", "X", "X", "X", "O", "O", "O", "X", "X", "X", "X", "O", "O", "X", "O", "O", "O", "O"}, {
//                "X", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "X", "O", "O", "X", "O", "O", "O", "O", "X"}, {
//                "X", "O", "O", "O", "X", "X", "X", "X", "X", "O", "X", "O", "X", "X", "X", "X", "O", "O", "O", "X"}, {
//                "X", "O", "O", "X", "X", "X", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "X"}, {
//                "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "O", "X", "O"}, {
//                "X", "O", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "X", "X", "O", "O", "O"}, {
//                "O", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X", "O"}, {
//                "X", "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "X", "O", "O", "X"}, {
//                "O", "O", "O", "O", "X", "X", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O"}, {
//                "O", "X", "X", "X", "X", "X", "X", "X", "O", "O", "X", "X", "X", "X", "X", "X", "X", "O", "X", "O"}, {
//                "X", "O", "X", "X", "X", "X", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X"}, {
//                "X", "O", "O", "O", "X", "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "X", "X", "X"}, {
//                "O", "O", "X", "O", "O", "O", "O", "X", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "O", "O"}, {
//                "O", "O", "X", "O", "O", "O", "O", "O", "O", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X", "X"}, {
//                "X", "O", "O", "O", "X", "O", "X", "X", "X", "O", "O", "X", "O", "X", "O", "X", "X", "O", "O", "O"
//        }};


//        List<int[]> difs = GeneralTool.compare2StrMatrix(comp1, comp2);
//        difs.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    char[][] board;
    boolean[][] searched;
    int m, n;

    /* 时间94%,为什么一开始想那么复杂呢
     * 其实只要扫描边界，然后把与边界连通的路先dfs标记了
     * 再扫描整个矩阵，扫到没标记的路直接死路就完事儿了
     * 之前的方法前面改X会影响到dfs，就复杂了 */
    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (n == 0) {
            return;
        }
        searched = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!searched[i][j] && board[i][j] == 'O') {
//                    if (!isSurrounded(i, j)) {
//                        dfs(i, j);
//                    }
//                }
//            }
//        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!searched[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

//    private boolean isSurrounded(int i, int j) {
//        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
//            return false;
//        }
//        board[i][j] = 'X';
//        if ((board[i + 1][j] == 'O' && !isSurrounded(i + 1, j)) ||
//                (board[i - 1][j] == 'O' && !isSurrounded(i - 1, j)) ||
//                (board[i][j + 1] == 'O' && !isSurrounded(i, j + 1)) ||
//                (board[i][j - 1] == 'O' && !isSurrounded(i, j - 1))) {
//            board[i][j] = 'O';
//            return false;
//        }
//        return true;
//    }

    private void dfs(int i, int j) {
        searched[i][j] = true;
        if (i + 1 < m && !searched[i + 1][j] && board[i + 1][j] == 'O') {
            dfs(i + 1, j);
        }
        if (i - 1 >= 0 && !searched[i - 1][j] && board[i - 1][j] == 'O') {
            dfs(i - 1, j);
        }
        if (j + 1 < n && !searched[i][j + 1] && board[i][j + 1] == 'O') {
            dfs(i, j + 1);
        }
        if (j - 1 >= 0 && !searched[i][j - 1] && board[i][j - 1] == 'O') {
            dfs(i, j - 1);
        }
    }
}
