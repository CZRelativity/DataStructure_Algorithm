package middle;

import tools.GeneralTool;

import java.util.Arrays;

public class setZeros73 {
    public static void main(String[] args) {
        setZeros73 t = new setZeros73();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1,1,1],[1,0,1],[1,1,1]]", "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]", "[\n" +
                "  [0,1,2,0],\n" +
                "  [3,4,5,2],\n" +
                "  [1,3,1,5]\n" +
                "]" };
        for (String e : eg) {
            int[][] matrix = GeneralTool.getArr2(e);
            setZeroes(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
    }

    //时间 99.9% 空间 O(m+n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    column[c] = true;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            if (row[r]) {
                Arrays.fill(matrix[r], 0);
            }
        }
        for (int c = 0; c < n; c++) {
            if (column[c]) {
                for (int r = 0; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
