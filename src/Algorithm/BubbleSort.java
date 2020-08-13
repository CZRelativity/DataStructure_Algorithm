package Algorithm;

public class BubbleSort extends Sort{

    public static void main(String[] args) {
        BubbleSort t=new BubbleSort();
//        System.out.println(Arrays.toString(t.sort(new int[]{5,9,1,6,8,2})));
        t.testRandom(8000);
    }

    public int[] sort(int[] arr){
        boolean flag;
        int temp;
        for (int i=0;i<arr.length-1;i++){//这个只是次数，总趟数总是length-1（未优化）
            flag=false;
            for (int j=0;j<arr.length-i-1;j++){//确实每一趟都会把这一次排序范围里面最大的放在最后，然后就不用再管最后一个了
//                所以往后放的排序，范围是往前缩的
//                比如说第一次把5个里面最大的放在第5，第二次把剩下4个里面最大的放在第4
//                每趟次数是length-趟数
                if (arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;//因为是挨个比较的，如果一趟没有交换过，那么就说明已经排好了，可以退出节省时间
                }
            }
            if (!flag){
                break;
            }
        }
        return arr;
    }
}
