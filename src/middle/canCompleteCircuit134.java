package middle;

public class canCompleteCircuit134 {
    public static void main(String[] args) {
        canCompleteCircuit134 t = new canCompleteCircuit134();
        t.test();
    }

    private void test() {
        int[][] gas = {{1, 2, 3, 4, 3, 2, 4, 1, 5, 3, 2, 4}, {5, 8, 2, 8}, {1, 2, 3, 4, 5}, {3, 3, 4}, {2, 3, 4}, {5, 1, 2, 3, 4}, {5, 4, 3, 1, 2}};
        int[][] cost = {{1, 1, 1, 3, 2, 4, 3, 6, 7, 4, 3, 1}, {6, 5, 6, 6,}, {3, 4, 5, 1, 2}, {3, 4, 4}, {3, 4, 3}, {4, 4, 1, 5, 1}, {3, 4, 5, 1, 2}};
        for (int i = 0; i < gas.length; i++) {
            System.out.println(canCompleteCircuit(gas[i], cost[i]));
        }
    }

    /* 100%，dalao的反证法 -> 尝试从i走一圈，发现只能走到j，于是i+1到j之间作为起点也全都被排除了
     * 1、假设i+1能走一圈，那么i+1必能走到j+1
     * 2、由于i可以走到i+1，那么i也必能走到j+1
     * 3、与实际不符，反证i+1不能走一圈，同理反证范围内所有 */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        while (start < len) {
            if (gas[start] - cost[start] >= 0) {
                int i = start + 1;
                int sum = gas[start] - cost[start];
                //for，循环结束先加再判断，所以退出循环的时候i不用+1
                for (; sum >= 0; i++) {
                    if (i == len) {
                        i = 0;
                    }
                    if (i == start) {
                        return start;
                    }
                    sum += gas[i] - cost[i];
                }
                /* 就从这个点跑一圈，刚好在满一圈的前一个点阵亡，然后+1又从这个点开始
                刚好在死循环？其实按照我们的原理这么跑一圈就排除了所有起点了 */
                if (i == start) {
                    break;
                }
                //妈的start怎么也不能往回跳啊
                if (start > i) {
                    start++;
                } else {
                    start = i;
                }
            } else {
                start++;
            }
        }
        return -1;
    }
}
