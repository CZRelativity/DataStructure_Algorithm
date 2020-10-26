package easy;

public class rob198 {
    public static void main(String[] args){
        rob198 t=new rob198();
        int[] eg1=new int[]{1,2,3,1};
        int[] eg2=new int[]{2,7,9,3,1};
        int[] eg3=new int[]{};
        int[] eg4=new int[]{2,1,1,2};
        int res=t.rob(eg1);
        System.out.println(res);
    }

    /*动态规划,dp关系式*/
    public int rob(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
