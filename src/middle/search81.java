package middle;

public class search81 {
    public static void main(String[] args) {
        search81 t = new search81();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 3, 5}, {1}, {2, 5, 6, 0, 0, 1, 2}, {2, 5, 6, 0, 0, 1, 2}};
        int[] egT = {1, 1, 0, 3};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(search(eg[i], egT[i]));
        }
    }

    //73%，二分法一定要努力地缩小区间
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        //细节：因为有length=1，left=0,right=0的情况，所以考虑left<=right
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //左端大于中点，表示前半段无序，旋转点在前半段，则后半段有序
            if (nums[left] > nums[mid]) {
                //细节：有可能正好在端点上，用<=
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //左端小于中点，表示前半段有序，旋转点在后半段
            else if (nums[left] < nums[mid]) {
                //判断是不是在有序前半段的范围内
                if (target >= nums[left] && target < nums[mid]) {
                    //在该区间进一步查找
                    right = mid - 1;
                } else {
                    //否则搜索另外一边（后半段）
                    left = mid + 1;
                }
            } else {
                /* 如果left与mid相等则无法判断是否有序，
                不过也正因为相等所以是在前面通过排除mid相等已经排除了这个left值了
                ，可以直接缩小范围 */
                left++;
            }
        }
        return false;
    }
}
