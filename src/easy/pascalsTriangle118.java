package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pascalsTriangle118 {
    public static void main(String[] args) {
        pascalsTriangle118 t = new pascalsTriangle118();
        t.trick(5);
        for (List<Integer> list : t.res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        onGenerate(new Integer[]{}, 1, numRows);
        return res;
    }

    public void trick(int numRows){
        Integer[] r1=new Integer[]{1};
        List<Integer> r1List=new ArrayList<>();
        Collections.addAll(r1List,r1);
        res.add(r1List);
        onTrick(r1,2,numRows);
    }

    private void onGenerate(Integer[] rLast, int row, int numRows) {
        if (row > numRows) {
            return;
        }
        Integer[] rCur = new Integer[row];
        rCur[0] = 1;
        int iCur = 1;
        while (iCur < row / 2) {
            rCur[iCur] = rLast[iCur] + rLast[iCur++ - 1];
        }
        if (iCur == row / 2 && row % 2 != 0) {
            rCur[iCur] = rLast[iCur++] * 2;
        }
        for (int iRet = row % 2 != 0 ? iCur - 2 : iCur - 1; iCur < row; ) {
            rCur[iCur++] = rCur[iRet--];
        }
        List<Integer> rList = new ArrayList<>();
        Collections.addAll(rList, rCur);
        res.add(rList);
        onGenerate(rCur, row + 1, numRows);
    }

    private void onTrick(Integer[] rLast, int row, int numRows){
        if(row>numRows){
            return;
        }
        rLast= Arrays.copyOf(rLast,row);
        rLast[row-1]=0;
        Integer[] rNext=new Integer[row];
        rNext[0]=0;
        System.arraycopy(rLast,0,rNext,1,row-1);
        for (int i=0;i<row;i++){
            rNext[i]=rNext[i]+rLast[i];
        }
        List<Integer> rList=new ArrayList<>();
        Collections.addAll(rList,rNext);
        res.add(rList);
        onTrick(rNext,row+1,numRows);
    }
}
