package middle;

public class compareVersion165 {
    public static void main(String[] args) {
        compareVersion165 t = new compareVersion165();
        t.test();
    }

    private void test() {
        String[] eg1 = {"0.1", "1.0.1", "7.5.2.4", "1.01", "1.0"};
        String[] eg2 = {"1.1", "1", "7.5.3", "1.001", "1.0.0"};
        for (int i = 0; i < eg1.length; i++) {
            System.out.println(compareVersion(eg1[i], eg2[i]));
        }
    }

    public int compareVersion(String version1, String version2) {
        int left1 = 0, left2 = 0;
        /* 要考虑的问题：前导0
         * 子集版本号 */
        while (left1 < version1.length() || left2 < version2.length()) {
            int[] parse1 = getVersionNum(version1, left1);
            int[] parse2 = getVersionNum(version2, left2);
            if (parse1[0] > parse2[0]) {
                return 1;
            } else if (parse2[0] > parse1[0]) {
                return -1;
            } else {
                left1 = parse1[1] + 1;
                left2 = parse2[1] + 1;
            }
        }
        return 0;
    }

    private int[] getVersionNum(String version, int left) {
        if (left >= version.length()) {
            return new int[]{0, left};
        }
        //适配最后一个子集，没有'.'的情况，注意索引溢出，用Integer.parseInt()根本就不用去0，自动去前导0了，引起不适
//        while (left < version.length() - 1 && version.charAt(left) == '0' && version.charAt(left + 1) != '.') {
//            left++;
//        }
        int right = left;
        //发现String.substring()方法的right(endIndex)指针是可以为length的
        while (right < version.length() && version.charAt(right) != '.') {
            right++;
        }
        return new int[]{Integer.parseInt(version.substring(left, right)), right};
    }

    private int compareVersionSplit(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i1 = 0, i2 = 0;
        while (i1 < split1.length || i2 < split2.length) {
            int sub1 = i1 >= split1.length ? 0 : Integer.parseInt(split1[i1]);
            int sub2 = i2 >= split2.length ? 0 : Integer.parseInt(split2[i2]);
            if (sub1 > sub2) {
                return 1;
            } else if (sub2 > sub1) {
                return -1;
            } else {
                i1++;
                i2++;
            }
        }
        return 0;
    }
}
