package interview;

import java.util.Arrays;

public class merge10_01 {
    public static void main(String[] args) {
        merge10_01 t = new merge10_01();
        t.test();
    }

    private void test() {
        int[][] a = {{1, 2, 3, 0, 0, 0}, {1}, {2, 0}};
        int[][] b = {{2, 5, 6}, {}, {1}};
        int[] m = {3, 1, 1};
        for (int i = 0; i < a.length; i++) {
            merge(a[i], m[i], b[i], b[i].length);
            System.out.println(Arrays.toString(a[i]));
        }
    }

    //100%
    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }
        int pA = 0, pB = 0;
        //A是存放的目标，pA是退出条件
        while (pA < m + n) {
            //A中的m个顺序检查完了，后面从B直接插入
            if (pA >= m + pB) {
                A[pA] = B[pB];
                pB++;
                //B还没用完，找到B的插入点，A整体后移
            } else if (pB < B.length && B[pB] < A[pA]) {
                //长度计算：m+pB是总有效长度，pA是当前有效长度，后面是还没有检查的长度
                System.arraycopy(A, pA, A, pA + 1, m + pB - pA);
                A[pA] = B[pB];
                pB++;
            }
            pA++;
        }
    }
}
