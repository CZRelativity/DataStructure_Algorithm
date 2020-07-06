package Easy_Test;

import Easy.palindrome;

public class test_palindrome {
    public static void main(String[] args) {
        palindrome t=new palindrome();
        System.out.println(t.Palindrome_Original(121));
        System.out.println(t.Palindrome_Original(-121));
        System.out.println(t.Palindrome_Original(10));
    }
}
