package easy;

import java.util.Arrays;

public class mergeArr88 {
    public static void main(String[] args) {
        mergeArr88 t = new mergeArr88();
        int[] eg11 = new int[]{1, 2, 3, 0, 0, 0};
        int[] eg12 = new int[]{2, 5, 6};
        int[] eg21=new int[]{1};
        int[] eg22=new int[]{};
        t.merge(eg21, 1, eg22, 0);
        System.out.println(Arrays.toString(eg21));
    }

    //时间100%
    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        int[] res=new int[m+n];
//        int i1=0,i2=0;
//        while(i1+i2<m+n){
//            if(i1==m){
//                res[i1+i2]=nums2[i2++];
//            }else if(i2==n){
//                res[i1+i2]=nums1[i1++];
//            }else {
//                if(nums1[i1]<=nums2[i2]){
//                    res[i1+i2]=nums1[i1++];
//                }else {
//                    res[i1+i2]=nums2[i2++];
//                }
//            }
//        }

        if(n==0){
            return;
        }
        int i1 = 0, i2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (i1 == m) {
                nums1[i] = nums2[i2++];
            } else {
                if (nums1[i] > nums2[i2]) {
                    //实为将后面的数组整体后移，给插入让出空位
                    System.arraycopy(nums1, i, nums1, i + 1, m-i1);
                    nums1[i] = nums2[i2++];
                }else {
                    i1++;
                }
            }
            if (i2 == n) {
                break;
            }
        }
    }
}
