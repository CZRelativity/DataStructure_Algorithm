package sword;

import java.util.Arrays;

public class getLeastNumbers40 {
    public static void main(String[] args) {
        getLeastNumbers40 t = new getLeastNumbers40();
        t.test();
    }

    private void test() {
        int[][] arr = {{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, {3, 2, 1}, {0, 1, 2, 1}};
        int[] k = {8, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(getLeastNumbers(arr[i], k[i])));
        }
    }

    //api
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    /* 99%，范围有限的情况下，跟甜姐新学的计数排序！
     * 已知0<=arr[i]<=10000 */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] count = new int[10001];
        for (int a : arr) {
            count[a]++;
        }
        int[] ret = new int[k];
        int p = 0;
        for (int i = 0; i <= 10000; i++) {
            if (count[i] > 0) {
                //数字可能重复多次，需要嵌套循环
                for (int j = 0; j < count[i]; j++) {
                    ret[p] = i;
                    p++;
                    //细节：二重循环需要break两次，不如直接return
                    if (p == k) {
                        return ret;
                    }
                }
            }
        }
        return ret;
    }
}
