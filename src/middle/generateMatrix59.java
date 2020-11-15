package middle;

import java.util.Arrays;

public class generateMatrix59 {
    public static void main(String[] args) {
        generateMatrix59 t = new generateMatrix59();
        t.test();
    }

    private void test() {
        int[] eg = {1, 2, 3, 4};
        for (int e : eg) {
            System.out.println(Arrays.deepToString(generateMatrix(e)));
        }
    }

    //100% 索引整tu了
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        ret[0][0] = 1;
        int i = 0, j = 0, value = 1;
        while (value < n * n) {
            while (j + 1 < n && ret[i][j + 1] == 0) {
                ret[i][++j] = ++value;
            }
            while (i + 1 < n && ret[i + 1][j] == 0) {
                ret[++i][j] = ++value;
            }
            while (j - 1 > -1 && ret[i][j - 1] == 0) {
                ret[i][--j] = ++value;
            }
            while (i - 1 > -1 && ret[i - 1][j] == 0) {
                ret[--i][j] = ++value;
            }
        }
        return ret;
    }
}
