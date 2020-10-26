package easy;

import java.util.ArrayList;
import java.util.List;

public class palindrome9 {
    public static void main(String[] args) {
        palindrome9 t=new palindrome9();
        System.out.println(t.isPalindrome(121));
        System.out.println(t.isPalindrome(-121));
        System.out.println(t.isPalindrome(10));
    }

//    //22%
//    public boolean isPalindrome(int x) {
//        if(x<0){
//            return false;
//        }
//        List<Integer> numList=new ArrayList<>();
//        while(x>0){
//            numList.add(x%10);
//            x/=10;
//        }
//        int left=0,right=numList.size()-1;
//        while(left<right){
//            if(!numList.get(left++).equals(numList.get(right--))){
//                return false;
//            }
//        }
//        return true;
//    }

    //数学方法，按位反转该数，结果是否等于原数
    public boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int reverse=0,temp=x;
        while (temp!=0){
            reverse*=10;
            reverse+=temp%10;
            temp/=10;
        }
        return x==reverse;
    }
}
