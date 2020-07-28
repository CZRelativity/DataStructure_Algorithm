package Algorithm;

public class FibonacciSearch extends Search {

    public static void main(String[] args) {
        FibonacciSearch t = new FibonacciSearch();
        t.testRandom(20000,6000);
    }

    static int[] fibArr;

    public FibonacciSearch() {
        fibArr = new int[30];
        fibArr[0] = 1;
        fibArr[1] = 1;
        for (int i = 2; i < 30; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
    }

    public int search(int[] arr, int find) {
        return searchOfRange(arr, find, 0, arr.length - 1);
    }

    public int searchOfRange(int[] arr, int find, int left, int right) {
        if (left > right) {
            return -1;
        }
        int i;
        for (i = 1; i < 30; i++) {
            if (fibArr[i] - 1 >= right - left) {
                break;
            }
        }
        int mid = left + fibArr[i - 1] - 1;
        if (arr[mid] == find) {
            return mid;
        } else if (find > arr[mid]) {
            return searchOfRange(arr, find, mid + 1, right);
        } else return searchOfRange(arr, find, left, mid - 1);
    }
}
