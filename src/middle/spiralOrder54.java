package middle;

import tools.GeneralTool;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder54 {
    public static void main(String[] args) {
        spiralOrder54 t = new spiralOrder54();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1,2,3],[4,5,6],[7,8,9]]", "[[1, 2, 3, 4],[5, 6, 7, 8],[9,10,11,12]]", ""};
        for (String e : eg) {
            System.out.println(spiralOrder(GeneralTool.getArr2(e)));
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return ret;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return ret;
        }
        ret.add(matrix[0][0]);
        matrix[0][0] = Integer.MIN_VALUE;
        //退出循环标记，无路可走
        boolean noWay = false;
        for (int i = 0, j = 0; !noWay; ) {
            noWay = true;
            //右，走到底
            while (j + 1 < n && matrix[i][j + 1] != Integer.MIN_VALUE) {
                ret.add(matrix[i][++j]);
                matrix[i][j] = Integer.MIN_VALUE;
                noWay = false;
            }
            //下
            while (i + 1 < m && matrix[i + 1][j] != Integer.MIN_VALUE) {
                ret.add(matrix[++i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                noWay = false;
            }
            //左
            while (j - 1 > -1 && matrix[i][j - 1] != Integer.MIN_VALUE) {
                ret.add(matrix[i][--j]);
                matrix[i][j] = Integer.MIN_VALUE;
                noWay = false;
            }
            //上
            while (i - 1 > -1 && matrix[i - 1][j] != Integer.MIN_VALUE) {
                ret.add(matrix[--i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                noWay = false;
            }
        }
        return ret;
    }
}
