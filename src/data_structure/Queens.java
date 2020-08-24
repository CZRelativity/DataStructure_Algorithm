package data_structure;

import java.util.ArrayList;
import java.util.List;

public class Queens {

    public static void main(String[] args){
        Queens t=new Queens();
        t.formAns();
    }

    List<int[]> res=new ArrayList<>();

    public void formAns(){
        int[] ans=new int[8];
        playChess(0,ans);
        System.out.println(res.size());
    }

    public void playChess(int row,int[] ans){
        if (row==8){
            res.add(ans);
            return;
        }
        int i;
        for (i=0;i<8;i++){
            if(checkChess(i,row,ans)){
                ans[row]=i;
                playChess(row+1,ans);
            }
        }
    }

    public boolean checkChess(int i,int row,int[] ans){
        for(int j=row-1;j>=0;j--){
            if(i==ans[j]||Math.abs(row-j)==Math.abs(i-ans[j])){
                return false;
            }
        }
        return true;
    }

}
