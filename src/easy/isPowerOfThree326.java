package easy;

public class isPowerOfThree326 {
    public static void main(String[] args) {

    }

    private void test() {

    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        /* 不能用n>1来退出循环，因为5/3依然等于1 */
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
