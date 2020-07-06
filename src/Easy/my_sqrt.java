package Easy;

public class my_sqrt {
    public int Sqrt_Original(int x) {
        double x_sqrt = (double) x / 2;
        while (Math.abs(x_sqrt * x_sqrt - x) > 0.001) {
            x_sqrt = (x_sqrt + x / x_sqrt) / 2;
        }
        return (int) x_sqrt;
    }
}
