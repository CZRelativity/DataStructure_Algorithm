package interview;

import tools.GeneralTool;

import java.util.Arrays;

class rotate01_07 {
    public static void main(String[] args) {
        rotate01_07 t = new rotate01_07();
        t.test();
    }

    private void test() {
        String[] eg = {"[\n" +
                "  [1,2,3],\n" +
                "  [4,5,6],\n" +
                "  [7,8,9]\n" +
                "]", "[\n" +
                "  [ 5, 1, 9,11],\n" +
                "  [ 2, 4, 8,10],\n" +
                "  [13, 3, 6, 7],\n" +
                "  [15,14,12,16]\n" +
                "]",};
        for (String e : eg) {
            int[][] matrix = GeneralTool.getArr2(e);
            rotate(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
    }

    //100%
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        //外层循环：层数，至少除去外层还剩的length至少2，才需要继续旋转
        for (int layer = 0; size - layer * 2 > 1; layer++) {
            //内层
            for (int j = layer + 1; j < size - layer; j++) {
                swap(matrix, layer, j, j, size - 1 - layer);
                swap(matrix, layer, j, size - 1 - layer, size - 1 - j);
                swap(matrix, layer, j, size - 1 - j, layer);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
