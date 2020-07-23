package Easy;

public class two_sum {//Hashmap待写
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

    public int[] Two_Sum_Original(int[] nums, int target) {
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
}
