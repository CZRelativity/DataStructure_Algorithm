package middle;

import java.util.Arrays;
import java.util.List;

public class maximalSquare221 {
    public static void main(String[] args) {
        maximalSquare221 t = new maximalSquare221();
        t.test();
    }

    private void test() {
        char[][][] eg = {{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}};
        for (char[][] e : eg) {
            System.out.println(maximalSquare(e));
        }
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        //最大面积->最大边长
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //状态表达式：左、左上、上三个位置都1，则该位置得2（2*2=4格），都2则该位置得3
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
//        List<int[]> res = Arrays.asList(dp);
//        res.forEach(ints -> System.out.println(Arrays.toString(ints)));
        return max * max;
    }
}
