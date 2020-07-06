package Easy_Test;

import Easy.reverse;

public class test_reverse {
    public static void main(String[] args) {
        reverse t = new reverse();
        System.out.println(t.Reverse_Original(123));
        System.out.println(t.Reverse_Simple(-123));
        System.out.println(t.Reverse_String_Exception(120));
    }
}
