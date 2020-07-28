package Algorithm;

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
        System.out.println(search(arr,target));
        Date d2=new Date();
        System.out.println("Search "+size+" Integers cost "+(d2.getTime()-d1.getTime())
                +" ms by "+this.getClass().getSimpleName());
    }

    public int search(int[] arr,int find){
        return 0;
    }
}
