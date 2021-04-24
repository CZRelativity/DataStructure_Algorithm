package sword;

class maxSubArray42 {
    public static void main(String[] args) {
        maxSubArray42 t = new maxSubArray42();
        t.test();
    }

    private void test() {
        int[][] eg = {{-2, -1}, {-1}, {-2, 1, -3, 4, -1, 2, 1, -5, 4}};
        for (int[] e : eg) {
            System.out.println(maxSubArray(e));
        }
    }

    //98%
    public int maxSubArray(int[] nums) {
        //要求[-1] ret:-1，[-2,-1] ret:-1
        int max = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum == Integer.MIN_VALUE) {
                sum = num;
            } else {
                sum += num;
            }
            //判断大小要放在归0之前，否则归0会使结果不会出现负数
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
