package algorithm;

public class RadixSort extends Sort {

    public static void main(String[] args){
        RadixSort t=new RadixSort();
        t.testRandom(8000);
    }

    @Override
    public int[] sort(int[] arr){
        int[][] bucket=new int[10][arr.length];
        //桶
        int[] bucketTop=new int[10];
        //用来标记每次每个桶里面放了多少个
        int tens=1;
        while(bucketTop[0]!=arr.length){
            bucketTop=new int[10];
            //用来做退出循环条件了，所以判断之后再清空
            for (int value : arr) {
                //这边改为增强for循环，看着舒服了很多
                switch (value / tens % 10) {
                    //直接对10求余得个位，除以10再对10求余得十位，以此类推
                    case 0:
                        bucket[0][bucketTop[0]++] = value;
                        break;
                        //其实bucketTop是一个index数组哦
                    case 1:
                        bucket[1][bucketTop[1]++] = value;
                        break;
                    case 2:
                        bucket[2][bucketTop[2]++] = value;
                        break;
                    case 3:
                        bucket[3][bucketTop[3]++] = value;
                        break;
                    case 4:
                        bucket[4][bucketTop[4]++] = value;
                        break;
                    case 5:
                        bucket[5][bucketTop[5]++] = value;
                        break;
                    case 6:
                        bucket[6][bucketTop[6]++] = value;
                        break;
                    case 7:
                        bucket[7][bucketTop[7]++] = value;
                        break;
                    case 8:
                        bucket[8][bucketTop[8]++] = value;
                        break;
                    case 9:
                        bucket[9][bucketTop[9]++] = value;
                        break;
                    default:
                        break;
                }
            }
            int indexNewArr=0;
            for(int j=0;j<10;j++){
                //遍历桶
                if(indexNewArr==arr.length){
                    break;
                }
                if(bucketTop[j]!=0){
                    int t=0;
                    //因为是顺序拿的，所以必须要创个临时的i了
                    while(t<bucketTop[j]){
                        arr[indexNewArr++]=bucket[j][t];
                        bucket[j][t++]=0;
                    }
                }
            }
            tens*=10;
            //重要
        }
        return arr;
    }
}
