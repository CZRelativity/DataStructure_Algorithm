package middle;

public class uniquePath62 {

    public static void main(String[] args) {
        uniquePath62 t = new uniquePath62();
        t.test();
    }

    private void test() {
        int[][] eg = new int[][]{{3, 2}, {7, 3}, {1, 1}};
        for (int[] e : eg) {
            System.out.println(uniquePathsDp(e[0], e[1]));
        }

    }

    private int numPaths;

    public int uniquePaths(int m, int n) {
        numPaths = 0;
        //m*n的格子，转成坐标
        search(0, 0, m - 1, n - 1);
        return numPaths;
    }

    //草，疯狂超时
    private void search(int x, int y, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            numPaths++;
            return;
        }
        //先往右呗
        if (x < targetX) {
            search(x + 1, y, targetX, targetY);
        }
        if (y < targetY) {
            //传的int，没让出path，那基本类型都不用回溯
            search(x, y + 1, targetX, targetY);
        }
    }

    //dp写法，杨辉三角？？？哎呀，巧了
    public int uniquePathsDp(int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    /* dp状态方程，到达点(i,j)一定是通过i-1+1即从上面向下一步
                    * 或者是j-1+1即从左边向右一步两种方法到达的，接下来就是到达目标
                    * 点上方的点的方法数和到达目标点左方的方法数，两条路都可以
                    * 符合分类加法原则，草 */
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
