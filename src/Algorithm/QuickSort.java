package Algorithm;

public class QuickSort extends Sort {
    public static void main(String[] args) {
        QuickSort t = new QuickSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr) {
        sortOfRange(arr, 0, arr.length - 1);
        return arr;
    }

    public void sortOfRange(int[] arr, int from, int to) {
        if (from >= to) {//传范围递归的一般终止条件？
            return;
        }
        int key = arr[to], indexKey = to, indexTemp, temp;
        for (int i = to - 1; i >= from; i--) {//设最后一位为快排基准（不用计算下标），从基准向前查找，找到比基准大的就放到基准的后面
            if (arr[i] > key) {
                indexTemp = i;
                while (indexTemp < indexKey) {//逐个向后移动，直到放到基准的后一位
                    temp = arr[indexTemp + 1];
                    arr[indexTemp + 1] = arr[indexTemp];
                    arr[indexTemp] = temp;
                    indexTemp++;
                }
                indexKey--;//每放完一个基准前移了一位
            }
        }
        sortOfRange(arr, from, indexKey - 1);//然后根据当前基准把数组分成了两部分
        sortOfRange(arr, indexKey + 1, to);//分别对这两部分进一步排序（不包括基准，也就是说其实基准在整个数组里的位置已经确定了）
    }
}
