package easy;

import java.util.LinkedList;

public class singleNumber136 {
    public static void main(String[] args) {
        singleNumber136 t=new singleNumber136();
        int[] eg1=new int[]{2,2,1};
        int res=t.singleNumberXOR(eg1);
        System.out.println(res);
    }

    public int singleNumberLinkedList(int[] nums) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int num : nums) {
            if (linkedList.contains(num)) {
                linkedList.remove((Integer) num);
            } else {
                linkedList.add(num);
            }
        }
        return linkedList.get(0);
    }

    /**时间99.8%
     * 由异或本身得0和其交换律结合律，只出现一次的数字，是天然的异或运算
     */
    public int singleNumberXOR(int[] nums){
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        return xor;
    }
}
