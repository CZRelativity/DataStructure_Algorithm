package easy;

import java.util.Arrays;

public class isAnagram242 {
    public static void main(String[] args) {
        isAnagram242 t=new isAnagram242();
        t.test();
    }

    private void test(){
        String[] egS={"anagram","rat"};
        String[] egT={"nagaram","car"};
        for(int i=0;i<egS.length;i++){
        System.out.println(isAnagram(egS[i],egT[i]));
        }
    }

    //任意字符的话，使用排序
    public boolean isAnagram(String s, String t) {
        char[] chars1=s.toCharArray();
        char[] chars2=t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }
}
