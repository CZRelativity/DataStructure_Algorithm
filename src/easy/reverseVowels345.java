package easy;

public class reverseVowels345 {
    public static void main(String[] args) {
        reverseVowels345 t = new reverseVowels345();
        t.test();
    }

    private void test() {
        String[] eg = {"aA", "hello", "leetcode"};
        for (String e : eg) {
            System.out.println(reverseVowels(e));
        }
    }

    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (isVowel(chars[left])) {
                right--;
            } else {
                left++;
            }
        }
        return String.valueOf(chars);
    }

    //元音字母居然还包括大写，啊这
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
