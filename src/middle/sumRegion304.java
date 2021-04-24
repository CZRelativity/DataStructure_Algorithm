package middle;

import tools.GeneralTool;

import java.util.Arrays;
import java.util.List;

public class sumRegion304 {
    public static void main(String[] args) {
        sumRegion304 t = new sumRegion304();
        t.test();
    }

    private void test() {
        String eg = "[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]";
        int[][] matrix = GeneralTool.getArr2(eg);
        NumMatrix n = new NumMatrix(matrix);
        List<int[]> list = Arrays.asList(n.dp);
        list.forEach(ints -> System.out.println(Arrays.toString(ints)));
        int[][][] sumRegion = {{{2, 1}, {4, 3}}, {{1, 1,}, {2, 2,}}, {{1, 2,}, {2, 4}}};
        for (int[][] region : sumRegion) {
            System.out.println(n.sumRegion(region[0][0], region[0][1], region[1][0], region[1][1]));
        }
    }

    class NumMatrix {

        int[][] dp;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return;
            }
            int n = matrix[0].length;
            if (n == 0) {
                return;
            }
            dp = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }
}
