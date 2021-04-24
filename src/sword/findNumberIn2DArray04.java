package sword;

import tools.GeneralTool;

public class findNumberIn2DArray04 {
    public static void main(String[] args) {
        findNumberIn2DArray04 t = new findNumberIn2DArray04();
        t.test();
    }

    private void test() {
        String eg = "[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]";
        int[] egT = {5, 20};
        int[][] matrix = GeneralTool.getArr2(eg);
        for (int t : egT) {
            System.out.println(findNumberIn2DArray(matrix, t));
        }
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][0] < target && binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
