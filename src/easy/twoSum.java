package easy;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result;
        twoSum t = new twoSum();
        result = t.solveHashMap(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] solveOriginal(int[] nums, int target) {
        int[] index = new int[]{0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    //时间74%,内存61%
    public int[] solveHashMap(int[] nums, int target){
        HashMap<Integer,Integer> map=new HashMap<>(nums.length);
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
