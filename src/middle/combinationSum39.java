package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum39 {
    public static void main(String[] args){
        combinationSum39 t=new combinationSum39();
        int[] eg1c=new int[]{2,3,6,7};
        int eg1t=7;
        int[] eg2c=new int[]{2,3,5};
        int eg2t=8;
        t.combinationSum(eg1c,eg1t);
        for(List<Integer> list: t.res){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> res=new ArrayList<>();

    //没有重复数字，每个数字也可以被重复选取，直接少了两个机制，不过还是要去重的
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combine(new ArrayList<>(),candidates,0,0,target);
        return res;
    }


    private void combine(List<Integer> cur, int[] candidates, int start,int sum, int target){
        if(sum==target){
            /* 构造一个包含指定Collection元素的ArrayList，按照Iterator的顺序排序
            * 避免添加同一个引用 */
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum>target){
            return;
        }
        //可以从上一个数开始，但是不能从上一个数之前开始了，不然就会出现3 5，5 3这样的重复
        for(int i=start;i<candidates.length;i++){
            cur.add(candidates[i]);
            combine(cur,candidates,i,sum+candidates[i],target);
            //回溯，按理说组合都不用标记？因为不存在顺序之说，所以排序之后直接往后取就可以了
            cur.remove(cur.size()-1);
        }
    }
}
