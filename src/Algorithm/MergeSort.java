package Algorithm;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        MergeSort t = new MergeSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr) {
        mergeOfRange(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeOfRange(int[] arr, int from, int to) {
        if (from >= to) {//传范围递归的一般终止条件？
            return;
        }
        int l = to - from + 1;
        mergeOfRange(arr, from, from + l / 2 - 1);
        mergeOfRange(arr, from + l / 2, to);//直接分成两部分
//        递归到每部分只有一个元素，开始返回然后接着运行下面的
        if (l == 2) {//如果只有两个元素则直接判断交换与否
            if (arr[from] > arr[to]) {
                int temp = arr[to];
                arr[to] = arr[from];
                arr[from] = temp;
            }
        } else {//多个元素则进入归并
            int[] tempArr = new int[l];
            int i1 = from, i2 = from + l / 2;
            for (int i = 0; i < l; i++) {
                if (i1 == from + l / 2) {
                    tempArr[i] = arr[i2++];
                } else if (i2 == from + l) {
                    tempArr[i] = arr[i1++];
                } else {
                    if (arr[i1] < arr[i2]) {
                        tempArr[i] = arr[i1++];
                    } else {
                        tempArr[i] = arr[i2++];
                    }
                }
            }
            System.arraycopy(tempArr, 0, arr, from, l);//（原数组名,原数组起始下标,新数组名,新数组起始下标,复制长度）
        }
    }
}
