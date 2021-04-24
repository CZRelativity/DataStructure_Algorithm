package sword;

public class cuttingRope14_1 {
    public static void main(String[] args) {
        cuttingRope14_1 t = new cuttingRope14_1();
        t.test();
    }

    private void test() {
        int[] eg = {2, 10,};
        for (int e : eg) {
            System.out.println(cuttingRope(e));
        }
    }

    //100%,任意分一个数乘积最大问题，尽可能不要分出1，然后分出最多个3就对了
    public int cuttingRope(int n) {
        //2，必须要分出1
        if (n == 2) {
            return 1;
        }
        //3，必须要分出1
        if (n == 3) {
            return 2;
        }
        int quotient = n / 3;
        int remainder = n % 3;

        if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        }
        if (remainder == 2) {
            return (int) Math.pow(3, quotient) * 2;
        }
        return (int) Math.pow(3, quotient);
    }
}
