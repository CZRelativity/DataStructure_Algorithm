package tools;

public class test_temp {
    public static void main(String[] args) {

        int[][] nums=new int[7][8];
        System.out.println(nums.length);
        for (int[] row:nums){
            for (int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
