package sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum57 {
    public static void main(String[] args) {
        twoSum57 t=new twoSum57();
        t.test();
    }

    private void test() {
        int[][] eg={{2,7,11,15},{10,26,30,31,47,60}};
        int[] egT={9,40};
        for(int i=0;i<eg.length;i++){
            System.out.println(Arrays.toString(twoSum(eg[i], egT[i])));
        }
    }

    //11%
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i : nums) {
            if (sumMap.containsKey(i)) {
                return new int[]{sumMap.get(i), i};
            }
            sumMap.put(target - i, i);
        }
        return new int[]{};
    }
}
