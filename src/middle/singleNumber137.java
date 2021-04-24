package middle;

import java.util.HashMap;
import java.util.Map;

public class singleNumber137 {
    public static void main(String[] args) {
        singleNumber137 t = new singleNumber137();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 2, 3, 2}, {0, 1, 0, 1, 0, 1, 99}};
        for (int[] e : eg) {
            System.out.println(singleNumber(e));
        }
    }

    //    public int singleNumber(int[] nums) {
//        int xor=0;
//        for(int i:nums){
//            xor^=i;
//        }
//        int sum=0;
//        for(int i:nums){
//            sum+=i;
//        }
//        return sum-(sum-xor)/2*3;
//    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }
        for (Integer key : count.keySet()) {
            if (count.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
