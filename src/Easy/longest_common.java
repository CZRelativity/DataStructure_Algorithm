package Easy;

public class longest_common {
    public String Longest_Original(String[] strs) {
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
