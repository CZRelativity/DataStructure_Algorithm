package easy;

import java.util.Arrays;
import java.util.HashMap;

public class smallerNumbersThanCurrent1365 {
    public static void main(String[] args) {
        smallerNumbersThanCurrent1365 t=new smallerNumbersThanCurrent1365();
        t.test();
    }

    private void test() {
        int[][] eg={{8,1,2,2,3},{6,5,4,8},{7,7,7,7}};
        for(int[] e:eg){
            System.out.println(Arrays.toString(smallerNumbersThanCurrent(e)));
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);
        HashMap<Integer, Integer> firstIndexMap = new HashMap<>();
        for (int i = 0; i < sort.length; i++) {
            if (!firstIndexMap.containsKey(sort[i])) {
                firstIndexMap.put(sort[i], i);
            }
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = firstIndexMap.get(nums[i]);
        }
        return ret;
    }
}
