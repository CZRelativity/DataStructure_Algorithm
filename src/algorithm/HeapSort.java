package algorithm;

import java.util.Arrays;

public class HeapSort extends Sort {

    public static void main(String[] args) {
        HeapSort t = new HeapSort();
        t.test();
//        t.testRandom(8000);
    }

    private void test() {
        int[][] eg = {{6, 4, 8, 5, 7, 9, 1, 3, 2}, {4, 6, 8, 5, 9},};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(sort(e)));
        }
    }

    @Override
    public int[] sort(int[] arr) {
        int i, length = arr.length;
        /* 第一次，从第一个非叶子节点开始，由下至上由左至右，构建大顶堆，这里重复的时候每次从前一个非叶子结点开始，有点像冒泡
         * 为什么不能直接getMaxHeadHeap(0),hey，因为比较的时候我们只考虑自己的两个子结点，只有做了调整才要继续递归 */
        for (i = length / 2 - 1; i >= 0; i--) {
            getMaxHeadHeap(i, length, arr);
        }
        //大顶堆构建完成，最大值从头交换到尾，然后排除尾，整理堆重新满足大顶堆，然后重复
        for (; length > 1; length--) {
            swap(arr, 0, length - 1);
            //现在我们把一个小的数放在最前面，因为是一个大顶堆的缘故，所以只需要做一次自顶向下的变动，因为除了才交换的节点，其他所有父结点都大于他的子结点
            getMaxHeadHeap(0, length - 1, arr);
            //之前这里也写的length,就有可能动到已经排好的末尾元素
        }
        return arr;
    }

//    public int[] sort(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return arr;
//        }
//        int i, length = arr.length;
//        // 构建大顶堆，这里其实就是把待排序序列，变成一个大顶堆结构的数组
//        for (i = length / 2 - 1; i >= 0; i--) {
//            getHeap(i, length, arr);
//        }
//        // 交换堆顶和当前末尾的节点，重置大顶堆
//        for (i = length - 1; i > 0; i--) {
//            swap(arr, 0, i);
//            length--;
//            getHeap(0, length, arr);
//        }
//        return arr;
//    }


    /**
     * 将以非叶子结点i对应的子树调整成大顶堆
     *
     * @param i      非叶子结点在数组中的索引
     * @param length 剩余需要调整的元素
     * @param arr    目标排序数组
     */
    public void getMaxHeadHeap(int i, int length, int[] arr) {
//        int t = i * 2 + 1;//i的左子结点对应的数组下标
//        int temp = arr[i];//先将i处的值存作临时变量
//        for (; t < length; t = t * 2 + 1)//当前t的左子结点对应的下标
//        {
//            if (t + 1 < length && arr[t] < arr[t + 1]) {
//                t++;
//            }//对于同一父节点，指向较大的子结点
//            if (arr[t] > temp) {
//                arr[i] = arr[t];
//                i = t;
//            } else {//暂时把找到的较大的子结点的值给父节点，然后子结点作为新的父节点，继续向下找？
//                break;//!!!???
//            }
//        }
//        //当循环结束时，已经把以i为父结点的树的最大值放在了i处
//        arr[i] = temp;

        // 先根据堆性质，找出它左右节点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 默认当前节点（父节点）是最大值。
        int largestIndex = i;
        if (left < length && arr[left] > arr[largestIndex]) {
            // 如果有左节点，并且左节点的值更大，更新最大值的索引
            largestIndex = left;
        }
        if (right < length && arr[right] > arr[largestIndex]) {
            // 如果有右节点，并且右节点的值更大，更新最大值的索引
            largestIndex = right;
        }

        if (largestIndex != i) {
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(arr, i, largestIndex);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            getMaxHeadHeap(largestIndex, length, arr);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
