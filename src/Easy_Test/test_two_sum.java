package Easy_Test;

import Easy.two_sum;

public class test_two_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] index;
        two_sum t = new two_sum();
        index = t.Two_Sum_Original(nums, target);
        for (int x : index) {
            System.out.println(x);
        }
    }
}
