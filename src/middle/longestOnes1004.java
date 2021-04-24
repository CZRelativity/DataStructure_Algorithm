package middle;

class longestOnes1004 {
    public static void main(String[] args) {
        longestOnes1004 t = new longestOnes1004();
        t.test();
    }

    private void test() {
        int[][] A = {{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}};
        int[] K = {0, 3};
        for (int i = 0; i < A.length; i++) {
            System.out.println(longestOnes(A[i], K[i]));
        }
    }

    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        int max = 0;
        while (right < len) {
            //只管扣，不满足用负数表示就好
            if (A[right] == 0) {
                K--;
            }
            //K<0表示已经不满足条件，此时必须滑动窗口，无论如何都不能再增长
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
