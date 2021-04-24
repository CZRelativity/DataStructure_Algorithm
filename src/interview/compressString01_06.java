package interview;

public class compressString01_06 {
    public static void main(String[] args) {
        compressString01_06 t = new compressString01_06();
        t.test();
    }

    private void test() {
        String[] eg = {"aabcccccaaa", "abbccd"};
        for (String e : eg) {
            System.out.println(compressString(e));
        }
    }


    public String compressString(String S) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < S.length()) {
            int count = 1;
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                count++;
                i++;
            }
            builder.append(S.charAt(i)).append(count);
            i++;
        }
        return builder.length() < S.length() ? builder.toString() : S;
    }
}
