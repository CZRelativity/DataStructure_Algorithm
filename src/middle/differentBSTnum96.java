package middle;

public class differentBSTnum96 {
    public static void main(String[] args) {
        differentBSTnum96 t = new differentBSTnum96();
        int result=t.solveDP(4);
        System.out.println(result);
    }

    public int solveDP(int n) {
        int[] dp = new int[n + 1];
        //没有结点时仅有一种情况 null
        dp[0] = 1;
        //动态规划，求几个结点对应有几种子树的组合，结果放进dp数组
        for (int i = 1; i <= n; i++) {
            int curDP = 0;
            /*依次把几个结点分别作为根结点时的情况，
            利用BST的性质，左右子树分开从dp数组中取得组合数量
            然后把所有左右组合的数量相乘，相当于进行组合，得到一个结点作为
            中间结点时的组合数
             */
            for (int j = 1; j <= i; j++) {
                //左结点数是当前根结点以左的左右结点，右节点是总节点数到当前根结点的所有结点
                curDP += dp[j - 1] * dp[i - j];
            }
            dp[i] = curDP;
        }
        return dp[n];
    }
}
