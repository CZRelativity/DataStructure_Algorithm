package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.test(-80, -10, 50, 2);
    }


    private void test(int startY, int endY, int step, int T) {

    }

    private void testString() {
        String s = "hello";
        try {
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            System.out.println(s);
        }
    }

    private void testBytes() {
        byte[] bytes1 = new byte[]{(byte) 143, 0x0a};
        byte[] bytes2 = new byte[]{(byte) 0x0d, (byte) 0x0a};
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
    }

    private void testBuilderBuffer() {
        TestBuilderBuffer ts = new TestBuilderBuffer();
        StringBuilder tsBuilder = new StringBuilder();
        StringBuffer tsBuffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            ts.append(1);
            tsBuilder.append("1");
            tsBuffer.append("1");
            System.out.println(ts.getNum() == tsBuilder.length());
            System.out.println(ts.getNum() == tsBuffer.length());
            System.out.println(tsBuilder.length() == tsBuffer.length());
            System.out.println("----");
        }

        System.out.println(isInteger("-10000"));
    }

    static class TestBuilderBuffer {

        private Integer n = 0;

        public Integer getNum() {
            return n;
        }

        public void setNum(Integer n) {
            this.n = n;
        }

        public synchronized void append(Integer n) {
            this.n = this.n + n;
        }

    }

    static Pattern pattern = Pattern.compile("^-?\\d*$");

    static boolean isInteger(String s) {
        return pattern.matcher(s).matches();
    }
}
