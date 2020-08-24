package easy;

public class my_sqrt {
    public static void main(String[] args) {
        my_sqrt t=new my_sqrt();
        System.out.println(t.Sqrt_Original(1));
        System.out.println(t.Sqrt_Original(2));
    }

    public int Sqrt_Original(int x) {
        double x_sqrt = (double) x / 2;
        while (Math.abs(x_sqrt * x_sqrt - x) > 0.001) {
            x_sqrt = (x_sqrt + x / x_sqrt) / 2;
        }
        return (int) x_sqrt;
    }
}
