package sword;

import tools.GeneralTool;

public class maxValue47 {
    public static void main(String[] args) {
        maxValue47 t = new maxValue47();
        t.test();
    }

    private void test() {
        String[] eg = {"[\n" +
                "  [1,3,1],\n" +
                "  [1,5,1],\n" +
                "  [4,2,1]\n" +
                "]",
                "[[3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3],[0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2],[8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9],[1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7],[8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8],[4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9],[6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1],[8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3],[9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3],[0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8],[4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3],[2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3],[0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3],[0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5],[6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2],[7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0],[3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0],[5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7]]"};
        for (String e : eg) {
            System.out.println(maxValue(GeneralTool.getArr2(e)));
        }
    }

    int[][] memory;

    //100%，记忆化深搜，不记忆化超时
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memory = new int[m][n];
        memory[m - 1][n - 1] = grid[m - 1][n - 1];
        return dfs(grid, 0, 0, m, n);
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        int right = 0, down = 0;
        if (i < m - 1) {
            right = dfs(grid, i + 1, j, m, n);
        }
        if (j < n - 1) {
            down = dfs(grid, i, j + 1, m, n);
        }
        int ret = grid[i][j] + Math.max(right, down);
        //完成位置i,j的搜索以后即得到该位置到终点的最大value，使用数组进行存储，则无需重复搜索
        memory[i][j] = ret;
        return ret;
    }
}
