package Algorithm;

public class ShellSort extends Sort{

    public static void main(String[] args){
        ShellSort t=new ShellSort();
        t.testRandom(8000);
    }

    public int[] sort(int[] arr){//希尔排序为什么这么快 ？！
        //确实就是插入排序加入一个步长的概念
        int gap=arr.length;//步长
        while(gap!=0){
            gap/=2;
            for(int i=0,index;i<gap;i++){//组数
                index=i+gap;
                for (int pos,insert;index<arr.length;index+=gap){
                    insert=arr[index];
                    pos=index-gap;
                    while(pos>=0&&insert<arr[pos]){
                        arr[pos+gap]=arr[pos];//先把后一个位置写入当前位置的值，
                        pos-=gap;//然后把位置往前移一个，如果移动到0之前了，就退出循环了
                    }
                    if(pos!=index-gap){
                        arr[pos+gap]=insert;//因为退出循环的时候多移动了一次，这里自然要加上去
                    }
                }
            }
        }
        return arr;
    }
}
