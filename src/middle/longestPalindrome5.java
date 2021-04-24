package middle;

public class longestPalindrome5 {

    public static void main(String[] args) {
        longestPalindrome5 t = new longestPalindrome5();
        t.test();
    }

    private void test() {
        String[] eg = {"aaaa", "babad", "cbbd", "aa", "ccc"};
        for (String e : eg) {
            System.out.println(longestPalindrome(e));
        }
    }

    public String solveOriginal(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLength = 1, maxMidIndex = 1, sLength = chars.length;
        for (int i = 0; i < sLength - 1; i++) {
            //奇数回文的搜索
            int extend = 1, curLength = 1;
            while (i - extend >= 0 && i + extend < sLength &&
                    chars[i - extend] == chars[i + extend]) {
                extend++;
                curLength += 2;
                if (curLength > maxLength) {
                    maxLength = curLength;
                    maxMidIndex = i;
                }
            }
            //偶数回文的搜索
            extend = 1;
            curLength = 0;
            while (i + 1 - extend >= 0 && i + extend < sLength &&
                    chars[i + 1 - extend] == chars[i + extend]) {
                extend++;
                curLength += 2;
                if (curLength > maxLength) {
                    maxLength = curLength;
                    maxMidIndex = i;
                }
            }
        }
        if (maxLength % 2 != 0) {
            return s.substring(maxMidIndex - maxLength / 2,
                    maxMidIndex + maxLength / 2 + 1);
        } else {
            return s.substring(maxMidIndex - maxLength / 2 + 1,
                    maxMidIndex + maxLength / 2 + 1);
        }
    }

    //动态规划，dp[i][j]表示i到j是回文
    public String longestPalindrome(String s) {

        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[len][len];
        int maxI = 0, maxJ = 0, max = 1;
        for (int right = 1; right < len; right++) {//外层大，内层小，在0-3的时候使用了1-2的结果
            for (int left = 0; left < right; left++) {
                if (chars[right] == chars[left]//基本条件
                        && (right == left + 1//三种符合的情况，偶回文
                        || right - 1 == left + 1//奇回文
                        || isPalindrome[left + 1][right - 1]//扩展
                )) {
                    isPalindrome[left][right] = true;
                    if (right - left + 1 > max) {//要求最大
                        max = right - left + 1;
                        maxI = right;
                        maxJ = left;
                    }
                }
            }
        }
        return s.substring(maxJ, maxI + 1);

    }
}
