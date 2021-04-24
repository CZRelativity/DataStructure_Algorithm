package easy;

public class canConstruct383 {
    public static void main(String[] args) {
        canConstruct383 t = new canConstruct383();
        t.test();
    }

    private void test() {
        String[] egR = {"a", "aa", "aa"};
        String[] egM = {"b", "ab", "aab"};
        for (int i = 0; i < egM.length; i++) {
            System.out.println(canConstruct(egR[i], egM[i]));
        }
    }

    //仅小写,64%
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countMagazine = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            countMagazine[magazine.charAt(i) - 'a']++;
        }
        int cur;
        for (int j = 0; j < ransomNote.length(); j++) {
            cur = ransomNote.charAt(j) - 'a';
            countMagazine[cur]--;
            if (countMagazine[cur] < 0) {
                return false;
            }
        }
        return true;
    }
}
