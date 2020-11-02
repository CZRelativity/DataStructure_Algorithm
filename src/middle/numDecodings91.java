package middle;

public class numDecodings91 {
    public static void main(String[] args) {
        numDecodings91 t = new numDecodings91();
        t.test();
    }

    private void test() {
        String[] eg = new String[]{"2101", "12", "226", "0", "1",};
        /*
        将s->numDecodings(s)替换为方法引用如下，static方法用类名引用，
         非static方法用this引用
        */
        for (String s : eg) {
            System.out.println(numDecodings(s));
        }
    }

    public int numDecodings(String s) {
        int length = s.length();
        char[] numArr = s.toCharArray();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        if (numArr[0] == '0') {
            return 0;
        }
        dp[1] = 1;
        int comb;
        for (int i = 2; i < length + 1; i++) {
            comb = Integer.parseInt(s.substring(i - 2, i));
            if (comb == 10 || comb == 20) {
                //前后必须绑定，相当于一个数了已经，dp[i]=1*dp[i-2]
                dp[i] = dp[i - 2];
            } else if (comb > 10 && comb <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                if (numArr[i - 1] == '0') {
                    return 0;
                } else {
                    //一个单独的数，没有构成组合，那么还需要组合前i-1个数
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[length];
    }
}
