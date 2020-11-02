package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum40 {
    public static void main(String[] args) {
        combinationSum40 t = new combinationSum40();
        t.test();
    }

    List<List<Integer>> res;

    private void test(){
        int[][] egA={{10, 1, 2, 7, 6, 1, 5},{2, 5, 2, 1, 2},{1,1,1,1,1,1,}};
        int[] egT={8,5,3,};
        for(int i=0;i<egA.length;i++){
            combinationSum2(egA[i],egT[i]);
            //日了，List的toString方法这么香，他是怎么写的呢，在AbstractCollection里
            res.forEach(System.out::println);
            System.out.println();
        }
    }

    //时间44%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        Arrays.sort(candidates);
        combine(new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }

    private void combine(List<Integer> cur, int[] candidates, int start, int sum, int target) {
        if (sum == target) {
            /* 构造一个包含指定Collection元素的ArrayList，按照Iterator的顺序排序
             * 避免添加同一个引用 */
            res.add(new ArrayList<>(cur));
            return;
        }
        //再递归肯定是往上加的，超过就可以停止了，草，万一负数呢，哦说明了都是正整数
        if (sum > target) {
            return;
        }
        //可以从上一个数开始，但是不能从上一个数之前开始了，不然就会出现3 5 5 3这样的重复
        for (int i = start; i < candidates.length; i++) {
            /* 妈的为什么！加了这段以后又完美剪枝了 *这一剪枝的使用条件是有序！
            * &&的条件真实是依次判断的，相当于是一个if的嵌套！！！如果把边界写在前面，是可以提前退出的，就不会再
            * 进行后面可能导致空指针异常的判断，前面也写错了但是没有爆空指针草 */
            while(i>start&&i<candidates.length&&candidates[i-1]==candidates[i]){
                i++;
            }
            if(i>=candidates.length){
                break;
            }
            cur.add(candidates[i]);
            //List两种回溯的方法，一种是传new ArrayList<>(list)，另外一种是返回的时候把当前栈的add remove
            combine(cur, candidates, i + 1, sum + candidates[i], target);
            //回溯，按理说组合都不用标记？因为不存在顺序之说，所以排序之后直接往后取就可以了
            cur.remove(cur.size() - 1);
        }
    }
}
