package middle;

public class searchDisorder33 {
    public static void main(String[] args) {
        searchDisorder33 t = new searchDisorder33();
        t.test();
    }

    private void test() {
        int[][] eg = {{4, 5, 6, 7, 0, 1, 2}, {1}};
        int[] egT = {0, 1, 3};
        for (int[] e : eg) {
            for (int t : egT) {
                System.out.println(search(e, t));
            }
            System.out.println();
        }
    }

    public int search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    private int binary(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        int mid = (from + to) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[from] < nums[mid]) {
            //前半段有序
            if (nums[from] <= target && nums[mid] > target) {
                /* target在前半段，
                细节：要比较两个端点才可以确定是不是在范围内 */
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        } else if (nums[from] > nums[mid]) {
            //后半段有序
            if (nums[to] >= target && nums[mid] < target) {
                //target在后半段
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        } else {
            from++;
        }
        return binary(nums, from, to, target);
    }
}
