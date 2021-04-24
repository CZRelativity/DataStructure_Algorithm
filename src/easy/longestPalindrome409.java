package easy;

public class longestPalindrome409 {
    public static void main(String[] args) {
        longestPalindrome409 t = new longestPalindrome409();
        t.test();
    }

    private void test() {
        String[] eg = {"abccccdd"};
        for (String e : eg) {
            System.out.println(longestPalindrome(e));
        }
    }

    //71%
    public int longestPalindrome(String s) {
        //已知范围，数组模拟map
        int[] map = new int[58];
        for (int i = 0; i < s.length(); i++) {
            //A=65,a=97
            map[s.charAt(i) - 'A']++;
        }
        int length = 0;
        boolean haveOdd = false;
        for (int j : map) {
            if (j == 0) {
                continue;
            }
            if (j % 2 != 0) {
                if (haveOdd) {
                    j--;
                } else {
                    haveOdd = true;
                }
            }
            length += j;
        }
        return length;
    }
}
