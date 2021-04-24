package easy;

class addStrings415 {
    public static void main(String[] args) {
        addStrings415 t = new addStrings415();
        t.test();
    }

    private void test() {
        String[] num1 = {"11",};
        String[] num2 = {"123",};
        for (int i = 0; i < num1.length; i++) {
            System.out.println(addStrings(num1[i], num2[i]));
        }
    }

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int buf = Math.max(len1, len2);
        StringBuilder builder = new StringBuilder();
        int p1 = len1 - 1, p2 = len2 - 1;
        int carry = 0;
        for (int i = 0; i < buf; i++) {
            int cur = carry;
            carry = 0;
            if (p1 >= 0) {
                cur += num1.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                cur += num2.charAt(p2) - '0';
                p2--;
            }
            if (cur > 9) {
                cur -= 10;
                carry++;
            }
            builder.insert(0, cur);
        }
        if (carry == 1) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
