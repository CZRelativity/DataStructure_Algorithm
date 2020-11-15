package easy;

import java.util.Arrays;

public class missingNumber268 {
    public static void main(String[] args){
        missingNumber268 t=new missingNumber268();
        t.test();
    }

    private void test(){
        int[][] eg={{3,0,1},{0,1},{9,6,4,2,3,5,7,0,1},{0}};
        for(int[] e:eg){
            System.out.println(missingNumberMath(e));
        }
    }

    //排序时间复杂度O(nlogn)
    public int missingNumberSort(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumberMath(int[] nums){
        int n = nums.length;
        //高斯求前n项和公式
        int sum=n*(n+1)/2;
        int realSum=0;
        for (int num : nums) {
            realSum += num;
        }
        return sum-realSum;
    }
}
