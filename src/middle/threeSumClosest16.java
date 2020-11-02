package middle;

import java.util.Arrays;

public class threeSumClosest16 {
    public static void main(String[] args) {
        threeSumClosest16 t = new threeSumClosest16();
        t.test();
    }

    private void test() {
        int[][] egArr = {{-1, 2, 1, -4}, {0, 0, 0,}, {1, 1, 1, 1},};
        int[] egT = {1, 1, 0,};
        for (int i = 0; i < egArr.length; i++) {
            System.out.println(threeSumClosest(egArr[i], egT[i]));
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDis = Integer.MAX_VALUE;
        int closeSum = Integer.MAX_VALUE;
        for (int left = 0; left + 2 < nums.length; left++) {
            //好用好记的去重大法
            while (left > 0 && left + 2 < nums.length && nums[left] == nums[left - 1]) {
                left++;
            }
            if (left + 2 >= nums.length) {
                break;
            }
            for (int right = nums.length - 1; left + 1 < right; right--) {

                while (right < nums.length - 1 && left + 1 < right && nums[right] == nums[right + 1]) {
                    right--;
                }
                /* 草，写错了，这个if如果写在上面的while里面是只能退出while的，不能起到break的效果，如果下面不是判断而是直接代入索引的话
                就很容易空指针，但是居然一直都没有出错真的惊了,时间是不是就差在这里呢，好像不是 */
                if (left + 1 >= right) {
                    break;
                }

                int areaDis = Integer.MAX_VALUE;
                int areaSum = Integer.MAX_VALUE;
                for (int mid = left + 1; mid < right; mid++) {

                    int curDis = Math.abs(nums[left] + nums[right] + nums[mid] - target);
                    if (curDis == 0) {
                        return target;
                    }

                    if (curDis > areaDis) {
                        break;
                    } else {
                        areaDis = curDis;
                        areaSum = nums[left] + nums[right] + nums[mid];
                    }

                    while (mid < right && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    if (mid >= right) {
                        break;
                    }
                }
                if (areaDis < minDis) {
                    minDis = areaDis;
                    closeSum = areaSum;
                }
            }
        }
        return closeSum;
    }
}
