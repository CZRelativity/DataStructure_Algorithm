package easy;

public class addDigits258 {
    public static void main(String[] args) {
        addDigits258 t=new addDigits258();
        t.test();
    }

    private void test(){
        int[] eg={38,};
        for(int e:eg){
            System.out.println(addDigits(e));
        }
    }

    //100%，但要求O(1)，非递归非循环，可能只有公式法
    public int addDigits(int num) {
        return add(num);
    }

    private int add(int num){
        if(num<10){
            return num;
        }
        int sum=0;
        while (num>0){
            sum+=num%10;
            num/=10;
        }
        return add(sum);
    }
}
