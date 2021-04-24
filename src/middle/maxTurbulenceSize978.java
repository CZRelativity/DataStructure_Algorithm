package middle;

public class maxTurbulenceSize978 {
    public static void main(String[] args) {
        maxTurbulenceSize978 t = new maxTurbulenceSize978();
        t.test();
    }

    private void test() {
        int[][] eg = {{9, 4, 2, 10, 7, 8, 8, 1, 9}, {4, 8, 12, 16}, {100}};
        for (int[] e : eg) {
            System.out.println(maxTurbulenceSize(e));
        }
    }

    public int maxTurbulenceSize(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; ) {
            int curLen = Math.max(turbulence(arr, 1, i, true),
                    turbulence(arr, 1, i, false));
            if (curLen > max) {
                max = curLen;
            }
            if (curLen > 1) {
                i += curLen - 1;
            } else {
                i++;
            }
        }
        return max;
    }

    private int turbulence(int[] arr, int curLen, int i, boolean order) {
        if (i < arr.length - 1 && order && arr[i] < arr[i + 1]) {
            return turbulence(arr, curLen + 1, i + 1, false);
        }
        if (i < arr.length - 1 && !order && arr[i] > arr[i + 1]) {
            return turbulence(arr, curLen + 1, i + 1, true);
        }
        return curLen;
    }
}
