package sword;

public class translateNum46 {
    public static void main(String[] args) {
        translateNum46 t = new translateNum46();
        t.test();
    }

    private void test() {
        int[] eg = {12258,};
        for (int e : eg) {
            System.out.println(translateNum(e));
        }
    }

    //100%
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (numStr.charAt(i - 1) == '0') {
                dp[i] = dp[i - 1];
            } else {
                int consist = Integer.parseInt(numStr.substring(i - 1, i + 1));
                if (consist >= 10 && consist <= 25) {
                    //两条路，跟前一个组合或者不组合
                    if (i > 1) {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + 1;
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }
}
