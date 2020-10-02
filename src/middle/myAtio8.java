package middle;

public class myAtio8 {
    public static void main(String[] args) {
        myAtio8 t = new myAtio8();
        String example1 = "42";
        String example2 = "-42";
        String example3 = "4193 with words";
        String example4 = "words and 987";
        String example5 = "-91283472332";
        //输入字符串的情况一定要排除empty
        String example6 = "";
        String example7 = "1";
        String example8 = " ";
        String example9 = "9223372036854775808";
        int result = t.solveOriginal(example2);
        System.out.println(result);
    }

    //时间99.7%,内存82.3%!!!
    public int solveOriginal(String str) {
        //str==""
        if (str.isEmpty()) {
            return 0;
        }
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
            //str==" "
            if (i == str.length()) {
                return 0;
            }
        }
        char startChar = str.charAt(i);
        if (startChar == '+' || startChar == '-' || (startChar >= '0' && startChar <= '9')) {
            long formInt;
            if (startChar >= '0') {
                formInt = startChar - '0';
            } else {
                formInt = 0;
            }
            i++;
            char curChar;
            while (i < str.length()) {
                curChar = str.charAt(i);
                if (curChar >= '0' && curChar <= '9') {
                    formInt = formInt * 10 + (curChar - '0');
                    if (formInt > Integer.MAX_VALUE) {
                        if (startChar == '-') {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (startChar == '-') {
                formInt = -formInt;
            }
            return (int) formInt;
        }
        return 0;
    }
}
