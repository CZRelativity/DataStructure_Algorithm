package Algorithm;

public class InsertValueSearch extends Search {

    public static void main(String[] args) {
        InsertValueSearch t = new InsertValueSearch();
        t.testRandom(20000,6000);
    }

    public int search(int[] arr, int find) {
        return searchOfRange(arr, find, 0, arr.length - 1);
    }

    public int searchOfRange(int[] arr, int find, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (arr[left] == arr[right]) {
            if (arr[left] == find) {
                return left;
            }
        } else {
            int mid = left + (right - left) * (find - arr[left]) / (arr[right] - arr[left]);
            if (find == arr[mid]) return mid;
            else if (find < arr[mid]) {
                return searchOfRange(arr, find, left, mid - 1);
            } else return searchOfRange(arr, find, mid + 1, right);
        }
        return -1;
    }
}
