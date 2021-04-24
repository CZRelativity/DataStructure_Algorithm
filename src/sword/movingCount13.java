package sword;

public class movingCount13 {
    public static void main(String[] args) {
        movingCount13 t = new movingCount13();
        t.test();
    }

    private void test() {
        int[] m = {38, 3, 1, 16, 2, 3};
        int[] n = {15, 2, 1, 8, 3, 1};
        int[] k = {9, 17, 1, 4, 1, 0};
        for (int i = 0; i < m.length; i++) {
            System.out.println(movingCount(m[i], n[i], k[i]));
        }
    }

//    public int movingCount(int m, int n, int k) {
//        if (m < k + 1 && n < k + 1) {
//            return m * n;
//        }
//        int steps = gauss(k + 1);
//        if (m < k + 1) {
//            steps -= gauss(k + 1 - m);
//        }
//        if (n < k + 1) {
//            steps -= gauss(k + 1 - n);
//        }
//        return steps;
//    }
//
//    private int gauss(int n) {
//        return (1 + n) * n / 2;
//    }

    int count;
    boolean[][] searched;
    int m, n, k;

    //85%，非要深搜哦？
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        searched = new boolean[m][n];
        count = 0;
        dfs(0, 0);
        return count;
    }

    private void dfs(int i, int j) {
        if (bitSum(i) + bitSum(j) > k) {
            return;
        }
        count++;
        searched[i][j] = true;
        if (i + 1 < m && !searched[i + 1][j]) {
            dfs(i + 1, j);
        }
        if (i - 1 >= 0 && !searched[i - 1][j]) {
            dfs(i - 1, j);
        }
        if (j + 1 < n && !searched[i][j + 1]) {
            dfs(i, j + 1);
        }
        if (j - 1 >= 0 && !searched[i][j - 1]) {
            dfs(i, j - 1);
        }
    }

    private int bitSum(int i) {
        if (i < 10) {
            return i;
        } else {
            return i % 10 + i / 10;
        }
    }
}
