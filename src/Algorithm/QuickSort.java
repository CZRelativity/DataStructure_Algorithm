package Algorithm;

public class QuickSort extends Sort {
    public static void main(String[] args) {
        QuickSort t = new QuickSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr) {
        deal(arr, 0, arr.length - 1);
        return arr;
    }

    public void deal(int[] arr, int from, int to) {
        if (from >= to) {
            return;
        }
        int key = arr[to], indexKey = to, indexTemp, temp;
        for (int i = to - 1; i >= from; i--) {
            if (arr[i] > key) {
                indexTemp = i;
                while (indexTemp < indexKey) {
                    temp = arr[indexTemp + 1];
                    arr[indexTemp + 1] = arr[indexTemp];
                    arr[indexTemp] = temp;
                    indexTemp++;
                }
                indexKey--;
            }
        }
        if (indexKey > from) {
            deal(arr, from, indexKey - 1);
        }
        if (indexKey < to) {
            deal(arr, indexKey + 1, to);
        }
    }
}
