package Easy_Test;

import Easy.longest_common;

public class test_longest_common {
    public static void main(String[] args) {
        longest_common t=new longest_common();
        String[] strings1={"flower","flow","flight"};
        String[] strings2={"dog","racecar","car"};
        String[] strings3={};
        String[] strings4={"flower"};
        String[] strings5={"c","c"};
        String[] strings6={"aa","a"};
        System.out.println(t.Longest_Original(strings1));
        System.out.println(t.Longest_Original(strings2));
        System.out.println(t.Longest_Original(strings3));
        System.out.println(t.Longest_Original(strings4));
        System.out.println(t.Longest_Original(strings5));
        System.out.println(t.Longest_Original(strings6));
    }
}
