package easy;

public class mySqrt69 {
    public static void main(String[] args) {
        mySqrt69 t = new mySqrt69();
        t.test();
    }

    private void test() {
        for (int i = 16; i < 20; i++) {
            System.out.println(i + ":" + myRealSqrt(i));
        }
    }

    public int mySqrt(int x) {
//        double x_sqrt = (double) x / 2;
//        while (Math.abs(x_sqrt * x_sqrt - x) > 0.001) {
//            x_sqrt = (x_sqrt + x / x_sqrt) / 2;
//        }
//        return (int) x_sqrt;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x / 2;
        while (left < right) {
            /* 向上取整可避免死循环，mid永远至少left+1，如果重复mid=left
             * left=mid就会陷入死循环 */
            int mid = left +
                    (int) Math.ceil((right - left) / 2f);
            //为了避免加/乘溢出，使用减/除
            if (x / mid < mid) {
                //排除不符合条件的部分
                right = mid - 1;
            } else {
                //可能符合条件的部分不能贸然移动
                left = mid;
            }
        }
        return left;
    }

    //还比int简单
    public double myRealSqrt(double x) {
        double left = 0, right = x;
        while (Math.abs(right - left) > 10e-6) {
            double mid = (right - left) / 2f + left;
            //取left的话优先移right就完事儿了
            if (x / mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
