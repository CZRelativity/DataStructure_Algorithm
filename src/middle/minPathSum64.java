package middle;

public class minPathSum64 {
    public static void main(String[] args){
        minPathSum64 t=new minPathSum64();
        t.test();
    }

    private void test(){
        int[][][] eg={{{1,3,1},{1,5,1},{4,2,1}},};
        for(int[][] e:eg){
            System.out.println(minPathSum(e));
        }
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //每个点都可以是从左点往右或者从上点往下到达，选择更小的一条路
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
