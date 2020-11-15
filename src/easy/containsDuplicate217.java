package easy;

import java.util.*;
import java.util.stream.Collectors;

public class containsDuplicate217 {
    public static void main(String[] args){
        containsDuplicate217 t=new containsDuplicate217();
        t.test();
    }

    private void test(){
        int[][] eg={{1,2,3,1},{1,2,3,4},
                {1,1,1,3,3,4,3,2,4,2},};
        for(int[] e:eg){
            System.out.println(containsDuplicateSet(e));
        }
    }

    //这道题有意思的地方在于，你知道哪个Collection查询最快？
    public boolean containsDuplicate(int[] nums) {
        //HashSet的底层实现是HashMap，也就是Hash值作为key，所以去重
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    //Set去重法
    public boolean containsDuplicateSet(int[] nums){
        Set<Integer> set= Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length!=set.size();
    }
}
