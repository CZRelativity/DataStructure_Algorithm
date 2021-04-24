package easy;

import java.util.Arrays;

public class twoSum167 {
    public static void main(String[] args) {
        twoSum167 t = new twoSum167();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 7, 11, 15}, {0, 0, 0, 0},};
        int[] egT = {9, 0,};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(Arrays.toString(twoSum(eg[i], egT[i])));
        }
    }

    //时间:96%
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length && numbers[i] <= target; i++) {
            //跳过重复以加速查找
            while (i != 0 && numbers[i] == numbers[i - 1]) {
                i++;
            }
            int res = binarySearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (res != -1) {
                return new int[]{i + 1, res + 1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        int ret = binarySearch(arr, target, left, mid - 1);
        return ret == -1 ? binarySearch(arr, target, mid + 1, right) : ret;
    }
}
