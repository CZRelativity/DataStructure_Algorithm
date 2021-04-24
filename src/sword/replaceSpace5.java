package sword;

public class replaceSpace5 {
    public static void main(String[] args) {
        replaceSpace5 t = new replaceSpace5();
        t.test();
    }

    private void test() {
        String[] eg = {"We are happy.    "};
        for (String e : eg) {
            System.out.println(replaceSpace(e));
        }
    }

    //100%
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
