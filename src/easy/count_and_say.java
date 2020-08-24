package easy;

public class count_and_say {

//    ArrayList<String> says = new ArrayList<>();
//    public count_and_say() {
//        says.add("1");
//        for (int i = 1; i < 30; i++) {
//            says.add(Generate(says.get(i - 1)));
//        }
//    }
    public static void main(String[] args) {
        count_and_say t = new count_and_say();
        for (int i = 1; i <= 30; i++) {
            System.out.println(t.Say_Original(i));
        }
    }

    public String Say_Original(int n) {
        String say = "1";
        if (n == 1) return say;
        else {
            for (int i = 2; i <= n; i++) {
                say = Generate(say);
            }
        }
        return say;
    }

    public String Generate(String s) {
        String say = "";
        int count = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                say = (say + count) + c;
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
            if (i == s.length() - 1) {
                say = (say + count) + c;
            }
        }
        return say;
    }
}
