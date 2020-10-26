package middle;

import java.util.Arrays;

public class nextPermutation31 {
    public static void main(String[] args){
        nextPermutation31 t=new nextPermutation31();
        int[] eg1=new int[]{5,4,3,2,1};
        int[] eg2=new int[]{1,2,3};
        int[] eg3=new int[]{3,2,1};
        int[] eg4=new int[]{1,5,1};
        int[] eg5=new int[]{2,1,3};
        int[] eg6=new int[]{5,1,1};
        int[] eg7=new int[]{1,1,1,1,1};
        int[] eg8=new int[]{5,5,5,5,1,1,1,};
        int[] eg9=new int[]{5,2,2,1,1,};
        int[] eg10=new int[]{1,1,5};
        int[] eg11=new int[]{1,3,2};
        int[] eg12=new int[]{1,5,3,1};
        int[] eg13=new int[]{5,4,7,5,3,2};
        t.nextPermutation(eg2);
        System.out.println(Arrays.toString(eg2));
    }

    /* 实际上他这个排列完全不需要重新做比较，只是从前到后就复杂这么多吗
    * 从后到前遍历就可以直接避免一系列稀奇古怪的情况 */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length<2){
            return;
        }
        //从后望前升序的破坏者，循环的breaker
        int breaker=length-1;
        for(;breaker>0;breaker--){
            if(nums[breaker-1]<nums[breaker]){
                //因为要交换的是breaker的前一个，所以也可能是把breaker拿去交换，包括正向看是完全正排的情况
                for(int exchange=length-1;exchange>=breaker;exchange--){
                    if(nums[exchange]>nums[breaker-1]){
                        int temp=nums[breaker-1];
                        nums[breaker-1]=nums[exchange];
                        nums[exchange]=temp;
                        break;
                    }
                }
                reverseArr(nums,breaker,length-1);
                break;
            }
        }
        //完全的倒排情况，直接变成正排完事儿了
        if(breaker==0){
            reverseArr(nums,0,length-1);
        }
    }

    private void reverseArr(int[] arr,int from,int to){
        for (int left=from,right= to
             ;left<right;left++,right--){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
    }

//    public void nextPermutation(int[] nums) {
//        int length=nums.length;
//        //排除特殊情况，就不要用空数组来坑我了吧
//        if(length<2){
//            return;
//        }
//        if(length==2){
//            int temp=nums[0];
//            nums[0]=nums[1];
//            nums[1]=temp;
//            return;
//        }
//        //先要把前面全部一样的排除掉
//        int exclude=0;
//        while (exclude<length-1&&nums[exclude]==nums[exclude+1]) {
//            exclude++;
//            if(exclude==length-1){
//                return;
//            }
//        }
//        //本身就是一个倒排，就求一个全正排,只判断一个头不行，头一直在换的.凉了，最坏情况判断倒排都要遍历完，其实可能没这么麻烦，等于算正排就好了
//        if(nums[exclude]>nums[exclude+1]&&nums[exclude+1]>=nums[exclude+2]){
//            quickSort(nums,0,length-1,false);
//            //本身是某数开头排列的最后一个，也就是从第二位开始就是倒排，这时最后一位是剩下的最小值，要找一个比现在开头大的重新开头
//        }else if(nums[exclude+1]>nums[exclude+2]){
//            int nextHead=length-1;
//            while (nums[nextHead]<=nums[0]){
//                nextHead--;
//            }
//            int temp=nums[0];
//            nums[0]=nums[nextHead];
//            nums[nextHead]=temp;
//            quickSort(nums,1,length-1,false);
//        }else {
//            //其他情况倒排范围增大1即可,如果是完全正排要注意判断
//            for(int i=exclude+2;i<length;i++){
//                if(i==length-1||(i<length-1&&nums[i]>nums[i+1])){
//                    quickSort(nums,i-1,length-1,true);
//                    break;
//                }
//            }
//        }
//    }

//    //写个快排正排+倒排
//    public void quickSort(int[] arr,int from,int to,boolean reverse){
//        if(from>=to){
//            return;
//        }
//        int mark=to;
//        for(int i=mark-1;i>=from;i--){
//            //爽啊，正排+倒排，虽说这个下标还是有点晕
//            if((!reverse&&arr[i]>arr[mark])||
//                    (reverse&&arr[i]<arr[mark])){
//                int move=i;
//                while (move<mark){
//                    int temp=arr[move];
//                    arr[move]=arr[move+1];
//                    arr[move+1]=temp;
//                    move++;
//                }
//                --mark;
//            }
//        }
//        quickSort(arr,from,mark-1,reverse);
//        quickSort(arr,mark+1,to,reverse);
//    }
}
