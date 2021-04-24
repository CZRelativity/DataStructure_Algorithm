package interview;

public class isUnique01_01 {
    public static void main(String[] args) {
        isUnique01_01 t=new isUnique01_01();
        t.test();
    }

    private void test() {
        String[] eg={"leetcode","abc"};
        for(String s:eg){
            System.out.println(isUnique(s));
        }
    }

    //数组，100%
    public boolean isUnique(String astr) {
        //有限范围常用数组代替map
        int[] count = new int[128];
        int cur;
        for (int i = 0; i < astr.length(); i++) {
            cur = astr.charAt(i);
            if (count[cur] > 0) {
                return false;
            }
            count[cur]++;
        }
        return true;
    }

    //学习位运算方法

}
