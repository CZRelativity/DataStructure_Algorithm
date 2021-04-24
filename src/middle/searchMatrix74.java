package middle;

import tools.GeneralTool;

public class searchMatrix74 {
    public static void main(String[] args) {
        searchMatrix74 t = new searchMatrix74();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1],[3]]", "[[1],[3]]", "[[1,3,5,7],[10,11,16,20],[23,30,34,50]]", "[[1,3,5,7],[10,11,16,20],[23,30,34,50]]", "",};
        int[] egT = {1, 3, 3, 13, 0};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(searchMatrix(GeneralTool.getArr2(eg[i]), egT[i]));
        }
    }

    //外层二分写不出来，时间100%
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int row = 0;
//        int top = 0, bottom = m - 1, mid;
//        while (top < bottom) {
//            mid = (top + bottom) / 2;
//            if (matrix[mid][0] > target) {
//                bottom = mid - 1;
//            } else {
//                top = mid + 1;
//            }
//        }
//        while (row < m - 1 && matrix[row + 1][0] <= target) {
//            row++;
//            if (matrix[row][0] == target) {
//                return true;
//            }
//        }
        int left = 0, right = m - 1;
        while (left < right) {
            //向上取整也不用ceil，直接让/2至少有1就行了
            int mid = left + (right - left + 1) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                //我们需要的是<=0
                left = mid;
            }
        }
        return binarySearch(matrix[left], target, 0, n - 1) != -1;
    }

    private int binarySearch(int[] row, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (row[mid] == target) {
            return mid;
        }
        int ret = binarySearch(row, target, left, mid - 1);
        return ret != -1 ? ret : binarySearch(row, target, mid + 1, right);
    }
}
