package easy;

import java.util.HashMap;

public class wordPattern290 {
    public static void main(String[] args) {
        wordPattern290 t = new wordPattern290();
        t.test();
    }

    private void test() {
        String[] egPattern = {"aaa", "abba", "abba", "aaaa", "abba"};
        String[] eg = {"aa aa aa aa", "dog cat cat dog", "dog cat cat fish", "dog cat cat dog", "dog dog dog dog"};
        for (int i = 0; i < egPattern.length; i++) {
            System.out.println(wordPattern(egPattern[i], eg[i]));
        }
    }

    public boolean wordPattern(String pattern, String s) {
        /* "aaaa"与"dog cat cat dog" "abba"与"dog dog dog dog" 意味着双向都必须唯一，使用两个HashMap */
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> strMap = new HashMap<>();
        int left = 0, right = 0, i = 0;
        //可能还存在length不等的情况，在这里要注意防止溢出
        while (left < s.length() && i < pattern.length()) {
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            char curPattern = pattern.charAt(i);
            String curSubStr = s.substring(left, right);
            if (patternMap.containsKey(curPattern)) {
                if (!(patternMap.get(curPattern).equals(curSubStr))) {
                    return false;
                }
            } else {
                patternMap.put(curPattern, curSubStr);
            }
            if (strMap.containsKey(curSubStr)) {
                if (!(strMap.get(curSubStr).equals(curPattern))) {
                    return false;
                }
            } else {
                strMap.put(curSubStr, curPattern);
            }
            right++;
            left = right;
            i++;
        }
        //在这里排除length不等的情况
        return left == s.length() + 1 && i == pattern.length();
    }
}
