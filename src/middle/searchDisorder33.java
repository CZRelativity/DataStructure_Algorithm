package middle;

public class searchDisorder33 {
    public static void main(String[] args) {
        searchDisorder33 t=new searchDisorder33();
        t.test();
    }

    private void test(){
        int[][] eg={{4,5,6,7,0,1,2},{1}};
        int[] egT={0,1,3};
        for(int[] e:eg) {
            for (int t : egT) {
                System.out.println(search(e,t));
            }
            System.out.println();
        }
    }

    //无脑二分就100%了，啊这
    public int search(int[] nums, int target) {
        return binary(nums,0,nums.length-1,target);
    }

    private int binary(int[] nums,int from,int to, int target){
        if(from>to){
            return -1;
        }
        int mid=(from+to)/2;
        if(nums[mid]==target){
            return mid;
        }
        int res=binary(nums,from,mid-1,target);
        return res!=-1?res:binary(nums,mid+1,to,target);
    }
}
