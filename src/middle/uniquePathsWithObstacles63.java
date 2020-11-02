package middle;

import java.util.Arrays;

public class uniquePathsWithObstacles63 {
    public static void main(String[] args) {
        uniquePathsWithObstacles63 t = new uniquePathsWithObstacles63();
        t.test();
    }

    private void test() {
        int[][][] eg = new int[][][]{
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, {{1}},{{0,0}}
        };
        for (int[][] e : eg) {
            System.out.println(uniquePathsWithObstaclesDp(e));
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int targetX = obstacleGrid.length - 1,
                targetY = obstacleGrid[0].length - 1;
        //起点终点都不可以是1哦
        if (obstacleGrid[0][0] == 1 || obstacleGrid[targetX][targetY] == 1) {
            return 0;
        }
        numPaths = 0;
        searchDf(0, 0, obstacleGrid, targetX, targetY);
        return numPaths;
    }

    private int numPaths;

    private void searchDf(int x, int y, int[][] grid, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            numPaths++;
            return;
        }
        if (x < targetX && grid[x + 1][y] != 1) {
            searchDf(x + 1, y, grid, targetX, targetY);
        }
        if (y < targetY && grid[x][y + 1] != 1) {
            searchDf(x, y + 1, grid, targetX, targetY);
        }
    }

    public int uniquePathsWithObstaclesDp(int[][] obstacleGrid) {
        int targetX = obstacleGrid.length - 1,
                targetY = obstacleGrid[0].length - 1;
        //起点终点都不可以是1哦
        if (obstacleGrid[0][0] == 1 || obstacleGrid[targetX][targetY] == 1) {
            return 0;
        }
        int[][] dp = new int[targetX + 1][targetY + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= targetX; i++) {
            dp[i][0] = dp[i - 1][0];
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            }
        }
        for (int j = 1; j <= targetY; j++) {
            dp[0][j] = dp[0][j - 1];
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i <= targetX; i++) {
            for (int j = 1; j <= targetY; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[targetX][targetY];
    }
}
