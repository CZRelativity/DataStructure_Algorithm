package middle;

import java.util.Deque;

public class lengthOfLongestSubstring3 {
    public static void main(String[] args){
        lengthOfLongestSubstring3 t=new lengthOfLongestSubstring3();
        String example1="abcabcbb";
        String example2="bbbbb";
        String example3="pwwkew";
        String example4="au";
        int result=t.solveOriginal(example2);
        System.out.println(result);
    }

    //双指针，滑动窗口,时间87%，内存79%
    public int solveOriginal(String s){
        char[] charS = s.toCharArray();
        int length = charS.length;
        if(length<2){
            return length;
        }
        int windowLeft=0,windowPointer,windowRight=0,longestSubLength=1;
        char curChar;
        while(windowRight<length-1){
            //比较指针从原窗口的最右端开始
            windowPointer=windowRight;
            //右端指针移动到准备添加进窗口的位置
            windowRight++;
            curChar=charS[windowRight];
            //比较指针可以等于窗口左指针，保证了可以从右到左对整个窗口做比较，遇到相同的，就退出循环，得到了添加后的新窗口
            while(windowPointer>=windowLeft&&curChar!=charS[windowPointer]){
                windowPointer--;
            }
            //退出循环时的指针位置是相等的，或者是-1，所以新窗口是比较指针的后一位开始
            windowLeft=windowPointer+1;

            int curSubLength = windowRight - windowLeft+1;
            if(curSubLength>longestSubLength){
                longestSubLength=curSubLength;
            }

        }
        return longestSubLength;
    }
}
