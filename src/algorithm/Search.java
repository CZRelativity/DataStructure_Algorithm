package algorithm;

import java.util.Arrays;
import java.util.Date;

public class Search {
    public void testRandom(int size,int target){
        int[] arr=new int[size];
        for (int i=0;i<size;i++){
            arr[i]=(int)(Math.random()*size);
        }
        System.out.println(Arrays.toString(new RadixSort().sort(arr)));
        Date d1=new Date();
        int result=search(arr,target);
        System.out.println(result==-1?"Did not find the target!!!":
                "Located the target at index "+result);
        Date d2=new Date();
        System.out.println("Search "+size+" Integers cost "+(d2.getTime()-d1.getTime())
                +" ms by "+this.getClass().getSimpleName());
    }

    public int search(int[] arr,int find){
        return 0;
    }
}
