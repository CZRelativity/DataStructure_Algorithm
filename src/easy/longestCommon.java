package easy;

public class longestCommon {
    public static void main(String[] args) {
        longestCommon t=new longestCommon();
        String[] strings1={"flower","flow","flight"};
        String[] strings2={"dog","racecar","car"};
        String[] strings3={};
        String[] strings4={"flower"};
        String[] strings5={"c","c"};
        String[] strings6={"aa","a"};
        System.out.println(t.longestOriginal(strings1));
        System.out.println(t.longestOriginal(strings2));
        System.out.println(t.longestOriginal(strings3));
        System.out.println(t.longestOriginal(strings4));
        System.out.println(t.longestOriginal(strings5));
        System.out.println(t.longestOriginal(strings6));
    }

    public String longestOriginal(String[] strs) {
        String common = "";
        if (strs.length==0)return "";
        if (strs.length==1)return strs[0];
        short j;
        for (j=1;j<strs.length;j++){
            if(strs[j].length()<strs[0].length()){
                String temp=strs[0];
                strs[0]=strs[j];
                strs[j]=temp;
            }
        }
        for (short i = 0; i < strs[0].length(); i++) {
            for (j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i)!=strs[j].charAt(i)) break;}
            if (j == strs.length) {
                common=strs[0].substring(0,i+1);
            } else break;
        }
        return common;
    }
}
