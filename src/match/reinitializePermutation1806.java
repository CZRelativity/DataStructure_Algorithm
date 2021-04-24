package match;

import java.util.Arrays;

class reinitializePermutation1806 {
    public static void main(String[] args) {
        reinitializePermutation1806 t = new reinitializePermutation1806();
        t.test();
    }

    private void test() {
        int[] eg = {1000};
        for (int i : eg) {
            System.out.println(reinitializePermutation(i));
        }
    }

    public int reinitializePermutation(int n) {
        int[] origin = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = i;
        }
        int[] arr = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                perm[i] = origin[i / 2];
            } else {
                perm[i] = origin[n / 2 + (i - 1) / 2];
            }
        }
        int count = 1;
        while (!check(perm, origin)) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = Arrays.copyOf(arr, n);
            count++;
        }
        return count;
    }

    private boolean check(int[] ints1, int[] ints2) {
        return Arrays.toString(ints1).equals(Arrays.toString(ints2));
    }
}
