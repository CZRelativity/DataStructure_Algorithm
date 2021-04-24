package easy;

import java.util.Arrays;

public class sortArrayByParity905 {
    public static void main(String[] args) {
        sortArrayByParity905 t = new sortArrayByParity905();
        t.test();
    }

    private void test() {
        int[][] eg = {{3, 1, 2, 4}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(sortArrayByParity(e)));
        }
    }

    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (A[left] % 2 == 0) {
                left++;
                continue;
            }
            if (A[right] % 2 != 0) {
                right--;
                continue;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }
}
