package easy;

public class isSubsequence392 {
    public static void main(String[] args) {
        isSubsequence392 t = new isSubsequence392();
        t.test();
    }

    private void test() {
        String[] s = {"abc", "axc","aaaaaa"};
        String[] t = {"ahbgdc", "ahbgdc","bbaaaa"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(isSubsequence(s[i], t[i]));
        }
    }

    char[] tArr;

    public boolean isSubsequence(String s, String t) {
        tArr = t.toCharArray();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            start = search(start, tArr.length - 1, s.charAt(i));
            if (start == -1) {
                return false;
            }
            start++;
        }
        return true;
    }

    private int search(int from, int to, char target) {
        for (int i = from; i <= to; i++) {
            if (tArr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
