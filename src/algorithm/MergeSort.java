package algorithm;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        MergeSort t = new MergeSort();
        t.testRandom(8);
    }

    @Override
    public int[] sort(int[] arr) {
        mergeOfRange(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeOfRange(int[] arr, int from, int to) {
        if (from >= to) {
            //传范围递归的一般终止条件？
            return;
        }
        int len = to - from + 1;
        mergeOfRange(arr, from, from + len / 2 - 1);
        mergeOfRange(arr, from + len / 2, to);
        //直接分成两部分
        //递归到每部分只有一个元素，开始返回然后接着运行下面的
        if (len == 2) {
            //如果只有两个元素则直接判断交换与否
            if (arr[from] > arr[to]) {
                int temp = arr[to];
                arr[to] = arr[from];
                arr[from] = temp;
            }
        } else {//多个元素则进入归并
            int[] tempArr = new int[len];
            int i1 = from, i2 = from + len / 2;
            for (int i = 0; i < len; i++) {
                //如果子序列1已经放完了，那就直接放子序列2
                if (i1 == from + len / 2) {
                    tempArr[i] = arr[i2++];
                    //同理
                } else if (i2 == from + len) {
                    tempArr[i] = arr[i1++];
                } else {
                    if (arr[i1] < arr[i2]) {
                        tempArr[i] = arr[i1++];
                    } else {
                        tempArr[i] = arr[i2++];
                    }
                }
            }
            //临时有序序列排好了，直接拷贝替换原来的那部分序列
            //（原数组名,原数组起始下标,新数组名,新数组起始下标,复制长度）
            System.arraycopy(tempArr, 0, arr, from, len);
        }
    }
}
