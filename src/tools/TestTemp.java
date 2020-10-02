package tools;

import java.util.regex.Pattern;

public class TestTemp {

    public static void main(String[] args) {
        TestString ts = new TestString();
//        StringBuilder tsBuilder = new StringBuilder();
//        StringBuffer tsBuffer = new StringBuffer();
//        for (int i = 0; i < 1000; i++) {
//            ts.append(1);
//            tsBuilder.append("1");
//            tsBuffer.append("1");
//            System.out.println(ts.getNum() == tsBuilder.length());
//            System.out.println(ts.getNum() == tsBuffer.length());
//            System.out.println(tsBuilder.length() == tsBuffer.length());
//            System.out.println("----");
//
//        }

        System.out.println(isInteger("-10000"));

    }

    static class TestString {

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

    static Pattern pattern=Pattern.compile("^-?\\d*$");

    static boolean isInteger(String s){
        return pattern.matcher(s).matches();
    }
}
