package Easy_Test;

import Easy.count_and_say;

public class test_count_and_say {
    public static void main(String[] args) {
        count_and_say t = new count_and_say();
        for (int i = 1; i <= 30; i++) {
            System.out.println(t.Say_Original(i));
        }
    }
}
