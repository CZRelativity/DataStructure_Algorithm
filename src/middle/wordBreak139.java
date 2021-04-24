package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class wordBreak139 {
    public static void main(String[] args) {
        wordBreak139 t = new wordBreak139();
        t.test();
    }

    private void test() {
        String[] eg = {"leetcode", "applepenapple", "catsandog",};
        String[][] egD = {{"leet", "code"}, {"apple", "pen"}, {"cats", "dog", "sand", "and", "cat"}};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(wordBreak(eg[i], Arrays.asList(egD[i])));
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        uniqueDict = new HashSet<>(wordDict);
        memoryMap = new HashMap<>();
        return df(s, 0);
    }

    private boolean dp(String s) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                if (dp[i] && uniqueDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[length];
    }

    HashMap<Integer, Boolean> memoryMap;
    HashSet<String> uniqueDict;

    //记忆化递归
    private boolean df(String s, int start) {
        if (start == s.length()) {
            return true;
        }
        if (memoryMap.containsKey(start)) {
            return memoryMap.get(start);
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (uniqueDict.contains(s.substring(start, i))) {
                if (df(s, i)) {
                    memoryMap.put(i, true);
                    return true;
                }
            }
        }
        memoryMap.put(start, false);
        return false;
    }

}
