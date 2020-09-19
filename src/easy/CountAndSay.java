package easy;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay t = new CountAndSay();
        for (int i = 1; i <= 30; i++) {
            System.out.println(t.sayOriginal(i));
        }
    }

    public String sayOriginal(int n) {
        String say = "1";
        if (n == 1) return say;
        else {
            for (int i = 2; i <= n; i++) {
                say = generate(say);
            }
        }
        return say;
    }

    public String generate(String s) {
        StringBuilder say = new StringBuilder();
        int count = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                say.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
            if (i == s.length() - 1) {
                say.append(count).append(c);
            }
        }
        return say.toString();
    }
}
