package middle;

import java.util.Arrays;

public class nthSuperUglyNumber313 {
    public static void main(String[] args) {
        nthSuperUglyNumber313 t = new nthSuperUglyNumber313();
        t.test();
    }

    private void test() {
        int[][] egP = {{2, 7, 13, 19}};
        int[] egN = {12,};
        for (int i = 0; i < egP.length; i++) {
            System.out.println(nthSuperUglyNumber(egN[i], egP[i]));
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int size = primes.length;
        int[] primesFactor = new int[size];
        int primesProduct;
        int curMin, curMinPrime;
        for (int i = 1; i < n; ) {
            curMin = Integer.MAX_VALUE;
            curMinPrime = size;
            for (int j = 0; j < size; j++) {
                //只有在之前的dp上面乘，才能避免质因数有primes以外的
                primesProduct = dp[primesFactor[j]] * primes[j];
                if (primesProduct < curMin) {
                    curMin = primesProduct;
                    curMinPrime = j;
                }
            }
            //去重 2*7 与 7*2
            if (dp[i - 1] != curMin) {
                dp[i++] = curMin;
            }
            primesFactor[curMinPrime]++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
