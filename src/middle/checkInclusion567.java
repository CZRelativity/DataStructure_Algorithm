package middle;

public class checkInclusion567 {
    public static void main(String[] args) {
        checkInclusion567 t = new checkInclusion567();
        t.test();
    }

    private void test() {
        String[] s1 = {"adc", "ab", "ab"};
        String[] s2 = {"dcda", "eidbaooo", "eidboaoo"};
        for (int i = 0; i < s1.length; i++) {
            System.out.println(checkInclusion(s1[i], s2[i]));
        }
    }

    //检查s2是否包含s1的排列，比如s1是"ab"，s2有子串"ba"也可以返回true，需要连续，比较方便扫描
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int[] count = new int[26];
        boolean[] have = new boolean[26];
        //小写字母的范围有限，用数组作map
        for (int i = 0; i < len1; i++) {
            char c = s1.charAt(i);
            count[c - 'a']++;
            have[c - 'a'] = true;
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            char cRight = s2.charAt(right);
            if (count[cRight - 'a'] > 0) {
                count[cRight - 'a']--;
            } else {
                char cLeft = s2.charAt(left);
                if (have[cLeft - 'a']) {
                    count[cLeft - 'a']++;
                }
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
//        for (int i = 0; i <= s2.length() - len1; i++) {
//            char c = s2.charAt(i);
//            //中了一个字母就可以从这个位置开始扫描
//            if (count[c - 'a'] > 0) {
//                int j = 0;
//                while (j < len1) {
//                    if (i + j == s2.length()) {
//                        break;
//                    }
//                    c = s2.charAt(i + j);
//                    if (count[c - 'a'] == 0) {
//                        break;
//                    }
//                    count[c - 'a']--;
//                    j++;
//                }
//                //完成了s1.length()的扫描可以返回true
//                if (j == len1) {
//                    return true;
//                } else {
//                    //否则要依次把map还原到扫描之前
//                    while (j > 0) {
//                        j--;
//                        c = s2.charAt(i + j);
//                        count[c - 'a']++;
//                    }
//                }
//            }
//        }
        return false;
    }
}
