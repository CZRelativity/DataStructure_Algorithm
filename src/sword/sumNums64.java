package sword;

public class sumNums64 {
    public static void main(String[] args) {
        sumNums64 t = new sumNums64();
        t.test();
    }

    private void test() {
        int[] eg = {3, 9};
        for (int n : eg) {
            System.out.println(sumNums(n));
        }
    }

    //要求不准用公式法和迭代，100%
    public int sumNums(int n) {
        return cal(1, n, 0);
    }

    private int cal(int cur, int n, int sum) {
        if (cur > n) {
            return sum;
        }
        sum += cur;
        return cal(cur + 1, n, sum);
    }
}
