package algorithm;

public class BinarySearch extends Search{

    public static void main(String[] args){
        BinarySearch t=new BinarySearch();
        t.testRandom(8000,1000);
    }

    @Override
    public int search(int[] arr,int find){
        return searchOfRange(arr,find,0,arr.length-1);
    }

    public int searchOfRange(int[] arr, int find, int left, int right){
        if(left>right)
        {
            return -1;
        }
        int mid=(left+right)/2;
        if(arr[mid]==find){
            return mid;
        }else if(find<arr[mid]){
            return searchOfRange(arr,find,left,mid-1);
        }else {
            return searchOfRange(arr,find,mid+1,right);
        }
    }
}
