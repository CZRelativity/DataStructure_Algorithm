package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations17 {
    public static void main(String[] args){
        letterCombinations17 t=new letterCombinations17();
        String eg1="23";
        String eg2="8";
        String eg3="";
        //eg3 期望结果:[]
        t.letterCombinations(eg2);
        for(String s: t.res){
            System.out.print(s+" ");
        }
    }

    HashMap<Character,String> phoneNumberMap=new HashMap<>();

    List<String> res=new ArrayList<>();

    public letterCombinations17(){
        phoneNumberMap.put('2',"abc");
        phoneNumberMap.put('3',"def");
        phoneNumberMap.put('4',"ghi");
        phoneNumberMap.put('5',"jkl");
        phoneNumberMap.put('6',"mno");
        phoneNumberMap.put('7',"pqrs");
        phoneNumberMap.put('8',"tuv");
        phoneNumberMap.put('9',"wxyz");
    }

    //时间87.5%
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return res;
        }
        combinate(new StringBuilder(),digits,0,digits.length());
        return res;
    }

    public void combinate(StringBuilder builder,String digits,int i,int l){
        if(builder.length()==l){
            res.add(builder.toString());
        }else {
            StringBuilder curBuilder;
            for(;i<l;i++){
                for(char c:phoneNumberMap.get(digits.charAt(i)).toCharArray()){
                    //回溯
                    curBuilder=new StringBuilder(builder);
                    curBuilder.append(c);
                    //递归
                    combinate(curBuilder,digits,i+1,l);
                }
            }
        }
    }
}
