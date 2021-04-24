package easy;

import tools.GeneralTool;

public class surfaceArea892 {
    public static void main(String[] args) {
        surfaceArea892 t = new surfaceArea892();
        t.test();
    }

    private void test() {
        String[] eg = {"[[2]]", "[[1,2],[3,4]]", "[[1,0],[0,2]]", "[[1,1,1],[1,0,1],[1,1,1]]",
                "[[2,2,2],[2,1,2],[2,2,2]]"};
        for (String e : eg) {
            System.out.println(surfaceArea(GeneralTool.getArr2(e)));
        }
    }

    //33%
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        if (column == 0) {
            return 0;
        }
        int s = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int curHeight = grid[i][j];
                //0连上下表面积也没有
                if (curHeight == 0) {
                    continue;
                }
                s += curHeight * 4 + 2;
                if (i - 1 >= 0) {
                    s -= Math.min(grid[i - 1][j], curHeight);
                }
                if (i + 1 < row) {
                    s -= Math.min(grid[i + 1][j], curHeight);
                }
                if (j - 1 >= 0) {
                    s -= Math.min(grid[i][j - 1], curHeight);
                }
                if (j + 1 < column) {
                    s -= Math.min(grid[i][j + 1], curHeight);
                }
            }
        }
        return s;
    }
}
