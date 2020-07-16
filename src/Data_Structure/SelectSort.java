package Data_Structure;

public class SelectSort extends Sort {

    public static void main(String[] args){
        SelectSort t=new SelectSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr){
        int temp;
        int tempIndex;
        for (int i=0;i<arr.length-1;i++){//不仅指排序次数了
            //这里选从最小开始排
            temp=arr[i];
            tempIndex=i;
            for(int j=i+1;j<arr.length;j++){
                //因为是从左到右放的，所以每一次选择的范围都要覆盖到最后一个哈
                if(arr[j]<temp){
                    temp=arr[j];
                    tempIndex=j;
                }
            }
            if(tempIndex!=i){
                arr[tempIndex]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }
}
