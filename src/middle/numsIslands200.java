package middle;

import tools.GeneralTool;

public class numsIslands200 {
    public static void main(String[] args) {
        numsIslands200 t = new numsIslands200();
        t.test();
    }

    private void test() {
        String[][] eg = {{"111", "010", "111"},
                {"11110", "11010", "11000", "00000"},
                {"11000", "11000", "00100", "00011"}};
        for (String[] e : eg) {
            System.out.println(numIslands(GeneralTool.strArr2CharMatrix(e)));
        }
    }

    int m;
    int n;
    char[][] grid;

    //100%
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    //找到一个起始点，则dfs他的所有连通点，排除整个island
                    dfs(i, j);
                }
            }
        }
        return ret;
    }

    private void dfs(int i, int j) {
        grid[i][j] = '0';
        //右
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(i + 1, j);
        }
        //左
        if (i - 1 > -1 && grid[i - 1][j] == '1') {
            dfs(i - 1, j);
        }
        //下
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(i, j + 1);
        }
        //上
        if (j - 1 > -1 && grid[i][j - 1] == '1') {
            dfs(i, j - 1);
        }
    }
}
