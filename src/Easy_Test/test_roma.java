package Easy_Test;

import Easy.roma2int;

public class test_roma {
    public static void main(String[] args) {
        roma2int t = new roma2int();
        System.out.println(t.Roma_Original("III"));
        System.out.println(t.Roma_Original("IV"));
        System.out.println(t.Roma_Original("IX"));
        System.out.println(t.Roma_Original("LVIII"));
        System.out.println(t.Roma_Original("MCMXCIV"));
    }
}
