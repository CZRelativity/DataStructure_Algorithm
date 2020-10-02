package easy;

public class mySqrt {
    public static void main(String[] args) {
        mySqrt t=new mySqrt();
        System.out.println(t.sqrtOriginal(1));
        System.out.println(t.sqrtOriginal(2));
    }

    public int sqrtOriginal(int x) {
        double x_sqrt = (double) x / 2;
        while (Math.abs(x_sqrt * x_sqrt - x) > 0.001) {
            x_sqrt = (x_sqrt + x / x_sqrt) / 2;
        }
        return (int) x_sqrt;
    }
}
