package easy;

public class strStr {
    public static void main(String[] args) {
        strStr t=new strStr();
        System.out.println(t.strStrOriginal("hello","ll"));
        System.out.println(t.strStrOriginal("hello",""));
        System.out.println(t.strStrOriginal("aaaaa","bba"));
    }

    public int strStrOriginal(String haystack, String needle){
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }else return -1;
    }
}
