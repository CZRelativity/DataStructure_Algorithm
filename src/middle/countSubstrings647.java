package middle;

public class countSubstrings647 {
    public static void main(String[] args) {
        countSubstrings647 t = new countSubstrings647();
        t.test();
    }

    private void test() {
        String[] eg = {"aaa", "abc",};
        for (String s : eg) {
            System.out.println(countSubstrings(s));
        }
    }


    //95%，舒服了
    public int countSubstrings(String s) {
        int len = s.length(), count = len;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            count += oddPalindrome(chars, i);
            count += evenPalindrome(chars, i);
        }
        return count;
    }

    private int oddPalindrome(char[] chars, int start) {
        int count = 0;
        int left = start - 1, right = start + 1;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    private int evenPalindrome(char[] chars, int start) {
        int count = 0;
        int left = start - 1, right;
        if (left >= 0 && chars[left] == chars[start]) {
            right = start + 1;
            left--;
            count++;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
                count++;
            }
        }
        //因为上面会遍历每个出发的位置，所以偶数回文只算一边的，否则从前一个向右和后一个向左重复
//        right = start + 1;
//        if (right < chars.length && chars[start] == chars[right]) {
//            left = start - 1;
//            right++;
//            count++;
//            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
//                left--;
//                right++;
//                count++;
//            }
//        }
        return count;
    }
}
