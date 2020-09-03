package algorithm;

public class BinarySearchExtra extends Search {

    //速度上倒没有太大差别
    public static void main(String[] args) {
        BinarySearchExtra t = new BinarySearchExtra();
        t.testRandom(8000, 1000);
    }

    /**
     * 二分法查找（非递归）
     *
     * @param arr  查找目标的数组
     * @param find 查找的目标
     * @return 找到目标的下标，未找到时返回-1
     */
    @Override
    public int search(int[] arr, int find) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        //递归也是靠下标来终止的，但是否这个就是最好的退出循环条件呢
        while (left <= right) {
            mid = (right + left) / 2;
            if (arr[mid] == find) {
                return mid;
            } else if (arr[mid] > find) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
