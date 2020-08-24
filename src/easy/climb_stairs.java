package easy;

public class climb_stairs {
    public static void main(String[] args) {
        climb_stairs t = new climb_stairs();
        System.out.println(t.Climb_Original(1));
        System.out.println(t.Climb_Original(2));
        System.out.println(t.Climb_Original(3));
        System.out.println(t.Climb_Original(4));
        System.out.println(t.Climb_Original(5));
        System.out.println(t.Climb_Iteration(5));
        System.out.println(t.Climb_Original(45));
    }

    public int Climb_Original(int n) {
        if (n == 1) return 1;
        int[] climb_array = new int[n + 1];
        climb_array[1] = 1;
        climb_array[2] = 2;
        for (int i = 3; i <= n; i++) {
            //其实是迭代的思路，但是创建数组的方法把每一步的结果都存储起来了，后面可以直接从数组里面调值
            climb_array[i] = climb_array[i - 1] + climb_array[i - 2];
        }
        return climb_array[n];
    }

    public int Climb_Iteration(int n) {
        if (n == 2) {
            return 2;
        } else if (n >= 3) {
            return Climb_Iteration(n - 1) + Climb_Iteration(n - 2);
            //不存值的迭代，虽然看着简洁，但是比如5-2和4-1都=3却要跑两次
        } else return 1;
    }
}
