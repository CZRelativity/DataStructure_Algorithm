package easy;

public class climbStairs70 {
    public static void main(String[] args) {
        climbStairs70 t = new climbStairs70();
        System.out.println(t.climbOriginal(1));
        System.out.println(t.climbOriginal(2));
        System.out.println(t.climbOriginal(3));
        System.out.println(t.climbOriginal(4));
        System.out.println(t.climbOriginal(5));
        System.out.println(t.climbIteration(5));
        System.out.println(t.climbOriginal(45));
    }

    public int climbOriginal(int n) {
        if (n == 1) return 1;
        int[] climbArray = new int[n + 1];
        climbArray[1] = 1;
        climbArray[2] = 2;
        for (int i = 3; i <= n; i++) {
            //其实是迭代的思路，但是创建数组的方法把每一步的结果都存储起来了，后面可以直接从数组里面调值
            climbArray[i] = climbArray[i - 1] + climbArray[i - 2];
        }
        return climbArray[n];
    }

    public int climbIteration(int n) {
        if (n == 2) {
            return 2;
        } else if (n >= 3) {
            return climbIteration(n - 1) + climbIteration(n - 2);
            //不存值的迭代，虽然看着简洁，但是比如5-2和4-1都=3却要跑两次
        } else return 1;
    }
}
