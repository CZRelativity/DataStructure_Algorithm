package algorithm;

import java.util.Arrays;

public class InsertSort extends Sort {

    public static void main(String[] args) {
        InsertSort t = new InsertSort();
        t.testRandom(8000);
    }

    //手动拷贝数组
    public int[] sort_Native(int[] arr) {
        int[] arrOrdered = new int[]{arr[0]};
        int j;
        int insert;
        for (int i = 1; i < arr.length; i++) {
            int[] temp = new int[i + 1];
            insert=arr[i];
            if (insert <= arrOrdered[0]) {
                for (j = 1; j < i + 1; j++) {
                    temp[j] = arrOrdered[j - 1];
                }
                temp[0] = insert;
            } else {
                int tempJ = 0;
                j = 0;
                temp[tempJ++] = arrOrdered[j++];
                while (j < i) {
                    if (insert <= arrOrdered[j]) {
                        temp[tempJ++] = insert;
                        break;
                    } else {
                        temp[tempJ++] = arrOrdered[j++];
                    }
                }
                if (j == i) {
                    temp[tempJ] = insert;
                } else {
                    for (; tempJ < i + 1; tempJ++) {
                        temp[tempJ] = arrOrdered[tempJ - 1];
                    }
                }
            }
            arrOrdered = temp;
        }
        return arrOrdered;
    }

    //更新通过API拷贝数组
    public int[] sort_api(int[] arr){
        int[] ordered=new int[]{arr[0]};
        int insert;
        for (int i=1;i<arr.length;i++){
            insert=arr[i];
            if (insert<=ordered[0]){
                int[] temp = new int[i+1];
                System.arraycopy(ordered,0,temp,1,i);
                ordered=temp;
                ordered[0]=insert;
            }else if (insert>=ordered[i-1]){
                ordered= Arrays.copyOf(ordered,i+1);
                ordered[i]=insert;
            }else {
                for (int j=0;j<i-1;j++){
                    if (insert<=ordered[j+1]){
                        int[] temp=Arrays.copyOfRange(ordered,0,j+1);
                        //拷贝到某一位是不包含那一位的？是的
                        temp=Arrays.copyOf(temp,i+1);
                        temp[j+1]=insert;
                        System.arraycopy(ordered,j+1,temp,j+2,i-j-1);
                        //这里的长度计算:从原数组已经拷贝了0~j，
                        // 也就是j+1个元素，所以原数组自然还剩余i-j-1个元素（i总是当前有序数组的总长）
                        ordered=temp;
                        break;//切记
                    }
                }
            }
        }
        return ordered;
    }

    //每次移动整个数组，不拷贝数组T T差好远
    @Override
    public int[] sort(int[] arr){
        int insert;
        int index;
        for(int i=1;i<arr.length;i++){
            insert=arr[i];
            index=i-1;
            while(index>=0 && insert<arr[index]){
                //一样的思路，从0到i-1是ordered数组，i以后是依次待插入的元素（i同样是ordered数组的length）
//                从i-1到0从大到小寻找插入点，寻找的同时不断一直把前面的值后移一位，给插入元素留一个位置，由于是倒着查找的，所以只要要插入的大于等于就可以放在留的位置了
                arr[index+1]=arr[index];
                index--;
            }
            if(index+1!=i){
                //这个判断的用意是有没有寻找过，比如插入元素上来就比i-1大的话，是应该放在最后的，就不做后面的插入
                arr[index+1]=insert;
            }
        }
        return arr;
    }
}
