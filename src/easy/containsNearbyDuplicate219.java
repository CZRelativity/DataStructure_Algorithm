package easy;

import java.util.HashMap;

public class containsNearbyDuplicate219 {
    public static void main(String[] args){
        containsNearbyDuplicate219 t=new containsNearbyDuplicate219();
        t.test();
    }

    private void test(){
        int[][] eg={{1,2,3,1},{1,0,1,1},{1,2,3,1,2,3}};
        int[] egK={3,1,2};
        for(int i=0;i< eg.length;i++){
            System.out.println(containsNearbyDuplicate(eg[i],egK[i]));
        }
    }

    //97%，读题 存在满足条件即为true
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> firstPosMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(firstPosMap.containsKey(nums[i])&&i-firstPosMap.get(nums[i])<=k){
                return true;
            }else {
                firstPosMap.put(nums[i],i);
            }
        }
        return false;
    }
}
