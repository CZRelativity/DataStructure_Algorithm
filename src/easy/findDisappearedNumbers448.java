package easy;

import java.util.ArrayList;
import java.util.List;

class findDisappearedNumbers448 {
    public static void main(String[] args) {
        findDisappearedNumbers448 t = new findDisappearedNumbers448();
        t.test();
    }

    private void test() {
        int[] eg = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(eg));
    }

    /* 由于数组全是正数，可以用负来标记，
    将所有num看作数组下标，将数组中对应下标的数字置为负
     最后没有被置负的就是没出现过的*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //细节：如果已经负了就不要再取反了，取负了以后为了获得正确下标需要取绝对值
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
