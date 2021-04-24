package middle;

import tools.GeneralTool;

class searchMatrix240 {
    public static void main(String[] args) {
        searchMatrix240 t = new searchMatrix240();
        t.test();
    }

    private void test() {
        String[] eg = {"[[-5]]", "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]",
                "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"};
        int[] target = {-5, 5, 20};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(searchMatrix(GeneralTool.getArr2(eg[i]), target[i]));
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
//        int top = m - 1, bottom = 0;
//        while (bottom < top) {
//            int mid = bottom + (top - bottom + 1) / 2;
//            if (matrix[mid][0] > target) {
//                top = mid - 1;
//            } else {
//                bottom = mid;
//            }
//        }
//        int right = n - 1, left = 0;
//        while (left < right) {
//            int mid = left + (right - left + 1) / 2;
//            if (matrix[0][mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid;
//            }
//        }
//        return matrix[bottom][left] == target;
        for (int i = 0; i < m && matrix[i][0] <= target; i++) {
            if(matrix[i][0]==target){
                return true;
            }
            int left = 0, right = n - 1;
            //这里不加=号会漏，
            while (left <= right) {
                //向下取整，减法可以防止溢出
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (target < matrix[i][mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
