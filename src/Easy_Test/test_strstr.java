package Easy_Test;

import Easy.strStr;

public class test_strstr {
    public static void main(String[] args) {
        strStr t=new strStr();
        System.out.println(t.StrStr_Original("hello","ll"));
        System.out.println(t.StrStr_Original("hello",""));
        System.out.println(t.StrStr_Original("aaaaa","bba"));
    }
}
