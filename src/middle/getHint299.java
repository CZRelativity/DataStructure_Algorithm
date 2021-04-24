package middle;

public class getHint299 {
    public static void main(String[] args) {
        getHint299 t = new getHint299();
        t.test();
    }

    private void test() {
        String[] egS = {"1807", "1123", "1122"};
        String[] egG = {"7810", "0111", "1222"};
        for (int i = 0; i < egG.length; i++) {
            System.out.println(getHint(egS[i], egG[i]));
        }
    }

    public String getHint(String secret, String guess) {
        int length = secret.length();
        int[] countSecret = new int[10];
        for (int i = 0; i < length; i++) {
            countSecret[secret.charAt(i) - '0']++;
        }
        int a = 0, b = 0;
        int curSecret, curGuess;
        for (int j = 0; j < length; j++) {
            curSecret = secret.charAt(j) - '0';
            curGuess = guess.charAt(j) - '0';
            //2、然后位置一致的又算A不算B了，于是把B里面算重的减去，最后再减更方便
            if (curGuess == curSecret) {
                a++;
            }
            //1、就所有出现过的都先算B
            if (countSecret[curGuess] != 0) {
                b++;
                countSecret[curGuess]--;
            }
        }
        return a + "A" + (b - a) + "B";
    }
}
