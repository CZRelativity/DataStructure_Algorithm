package Easy_Test;

import Easy.length_of_last_word;

public class test_length_of_last_word {
    public static void main(String[] args) {
        length_of_last_word t=new length_of_last_word();
        System.out.println(t.Length_Original("Hello World"));
        System.out.println(t.Length_Original("a "));
        System.out.println(t.Length_Original("b a  "));
        System.out.println(t.Length_Original("       "));
    }
}
