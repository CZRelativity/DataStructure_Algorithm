package sword;

public class lengthOfLongestSubstring48 {
    public static void main(String[] args) {
        lengthOfLongestSubstring48 t = new lengthOfLongestSubstring48();
        t.test();
    }

    private void test() {
        String[] eg = {"", "a", "abcabcbb", "bbbbb", "pwwkew"};
        for (String e : eg) {
            System.out.println(lengthOfLongestSubstring(e));
        }
    }

    //双指针，利用map维护一个不重复的窗口
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = s.length(), left = 0;
        int[] ascMap = new int[128];
        int max = 0;
        for (int right = 0; right < len; right++) {
            char c = chars[right];
            while (ascMap[c] == 1) {
                ascMap[chars[left]]--;
                left++;
            }
            ascMap[c]++;
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
