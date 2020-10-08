package easy;

import java.util.Arrays;

public class reverseString344 {
    public static void main(String[] args){
        reverseString344 t=new reverseString344();
        String eg1="hello";
        String eg2="Hannah";
        String eg3="a";
        String eg4="";
        t.solveOriginal(eg4.toCharArray());
    }

    //双指针，时间99.98%，内存92.78%
    public void solveOriginal(char[] s){
        char temp;
        int left=0,right=s.length-1;
        while(left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
