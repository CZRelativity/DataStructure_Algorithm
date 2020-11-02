package middle;

import java.util.Arrays;

public class rotateImage48 {
    public static void main(String[] args) {
        rotateImage48 t = new rotateImage48();
        t.test();
    }

    private void test() {
        int[][][] eg = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}};
        for (int[][] m : eg) {
            rotate(m);
            Arrays.stream(m).forEach(l -> System.out.println(Arrays.toString(l)));
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        rotateLayer(matrix, 0, matrix.length - 1);
    }

    private void rotateLayer(int[][] matrix, int leftTop, int rightBottom) {
        if (leftTop >= rightBottom) {
            return;
        }
        int temp;
        for (int offset = 1; leftTop + offset <= rightBottom; offset++) {
            temp = matrix[leftTop][leftTop + offset];
            matrix[leftTop][leftTop + offset] = matrix[rightBottom - offset][leftTop];
            matrix[rightBottom - offset][leftTop] = matrix[rightBottom][rightBottom - offset];
            matrix[rightBottom][rightBottom - offset] = matrix[leftTop + offset][rightBottom];
            matrix[leftTop + offset][rightBottom] = temp;
        }
        rotateLayer(matrix, leftTop + 1, rightBottom - 1);
    }
}
