package middle;

import java.util.ArrayList;
import java.util.List;

public class zConvert6 {

    public static void main(String[] args){
        zConvert6 t=new zConvert6();
        String example1="LEETCODEISHIRING";
        String example2="AB";
        String result=t.solveOriginal(example1,2);
        System.out.println(result);
    }

    //时间73%
    public String solveOriginal(String s,int numRows){
        char[] chars = s.toCharArray();
        int length = s.length();
        if(length<=numRows){
            return s;
        }
        List<StringBuilder> rowList=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rowList.add(new StringBuilder());
        }
        int forward=0,back=0;
        for(int i=0;i<length;){
            if(forward<numRows){
                StringBuilder rowBuilder=rowList.get(forward);
                rowBuilder.append(chars[i]);
                i++;
                forward++;
                if(forward==numRows){
                    back=forward-2;
                }
            }else {
                if(back>0){
                    StringBuilder rowBuilder=rowList.get(back);
                    rowBuilder.append(chars[i]);
                    i++;
                    back--;
                }else {
                    forward=0;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder row:rowList){
            result.append(row);
        }
        return result.toString();
    }
}
