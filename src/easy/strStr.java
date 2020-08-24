package easy;

public class strStr {
    public static void main(String[] args) {
        strStr t=new strStr();
        System.out.println(t.StrStr_Original("hello","ll"));
        System.out.println(t.StrStr_Original("hello",""));
        System.out.println(t.StrStr_Original("aaaaa","bba"));
    }

    public int StrStr_Original(String haystack,String needle){
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }else return -1;
    }
}
