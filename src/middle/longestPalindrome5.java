package middle;

public class longestPalindrome5 {

    public static void main(String[] args){
        longestPalindrome5 t=new longestPalindrome5();
        System.out.println(t.solveOriginal("babad"));
        System.out.println(t.solveOriginal("cbbd"));
        System.out.println(t.solveOriginal("aa"));
        System.out.println(t.solveOriginal("ccc"));
    }

    public String solveOriginal(String s){
        if(s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLength=1,maxMidIndex=1,sLength=chars.length;
        boolean usingMid=true;
        for(int i=0;i<sLength-1;i++){
            int extend=1,curLength=1;
            while(i-extend>-1&&i+extend<sLength&&chars[i-extend]==chars[i+extend]){
                extend++;
                curLength+=2;
                if(curLength>maxLength){
                    maxLength=curLength;
                    maxMidIndex=i;
                    usingMid=true;
                }
            }
            extend=1;
            curLength=0;
            while(i+1-extend>-1&&i+extend<sLength&&chars[i+1-extend]==chars[i+extend]){
                extend++;
                curLength+=2;
                if(curLength>maxLength){
                    maxLength=curLength;
                    maxMidIndex=i;
                    usingMid=false;
                }
            }
        }
        if(usingMid){
            return s.substring(maxMidIndex-maxLength/2,maxMidIndex+maxLength/2+1);
        }else {
            return s.substring(maxMidIndex-maxLength/2+1,maxMidIndex+maxLength/2+1);
        }
    }
}
