package middle;

class longestCommonSubsequence1143 {
    public static void main(String[] args) {
        longestCommonSubsequence1143 t = new longestCommonSubsequence1143();
        t.test();
    }

    private void test() {
        String[] t1 = {"pmjghexybyrgzczy", "abcba", "bsbininm", "abcde", "abc", "abc"};
        String[] t2 = {"hafcdqbgncrcbihkd", "abcbcba", "jmjkbkjkv", "ace", "abc", "def"};
        for (int i = 0; i < t1.length; i++) {
            System.out.println(longestCommonSubsequence(t1[i], t2[i]));
        }
    }

    //dp[i][j]长度i的t1和长度j的t2的最长公共子串长度
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                //状态表达式
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[l1][l2];
    }
}
