package algorithm;

import java.util.Arrays;
import java.util.Date;

public class Sort {
    public void testRandom(int size){
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=(int)(Math.random()*size);
        }
        System.out.println(Arrays.toString(arr));
        Date d1=new Date();
        System.out.println(Arrays.toString(sort(arr)));
        Date d2=new Date();
        System.out.println("Sort "+size+" Integers cost "+(d2.getTime()-d1.getTime())+
                "ms by "+this.getClass().getSimpleName());
    }

    public int[] sort(int[] arr){
        return arr;
    }
}
