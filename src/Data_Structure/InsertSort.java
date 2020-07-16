package Data_Structure;

public class InsertSort extends Sort {

    public static void main(String[] args) {
        InsertSort t = new InsertSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr) {
        int[] arrOrdered = new int[]{arr[0]};
        int j;
        int insert;
        for (int i = 1; i < arr.length; i++) {
            int[] temp = new int[i + 1];
            insert=arr[i];
            if (insert <= arrOrdered[0]) {
                for (j = 1; j < i + 1; j++) {
                    temp[j] = arrOrdered[j - 1];
                }
                temp[0] = insert;
            } else {
                int tempJ = 0;
                j = 0;
                temp[tempJ++] = arrOrdered[j++];
                while (j < i) {
                    if (insert <= arrOrdered[j]) {
                        temp[tempJ++] = insert;
                        break;
                    } else {
                        temp[tempJ++] = arrOrdered[j++];
                    }
                }
                if (j == i) {
                    temp[tempJ] = insert;
                } else {
                    for (; tempJ < i + 1; tempJ++) {
                        temp[tempJ] = arrOrdered[tempJ - 1];
                    }
                }
            }
            arrOrdered = temp;
        }
        return arrOrdered;
    }
}
