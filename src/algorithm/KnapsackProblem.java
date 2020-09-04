package algorithm;

import java.util.Arrays;

public class KnapsackProblem {

    public static void main(String[] args) {
        KnapsackProblem t = new KnapsackProblem();
        t.value = new int[]{0, 30, 20, 15};
        t.weight = new int[]{0, 4, 3, 1};
        t.solve();
    }

    private int[] value;
    private int[] weight;
    private int[][] totalValue;

    public KnapsackProblem() {

    }

    public void solve() {
        //因为第一行第一列总是0，初始化就已经完成了，遍历的时候直接跳过就好
        //不过为了使下标不换算，value数组和weight数组的首位也放0了，以便直接共用下标
        int item = 1, size = 1;
        int maxSize = 0;
        for (int i : weight) {
            maxSize += i;
        }
        totalValue = new int[weight.length][maxSize + 1];
        //每个size要重新从第一个item开始遍历，第一行第一列全为0的好处就是重新遍历按照之前的思路放不下直接取上一个item，也是从0开始
        for (; size <= maxSize; item = 1, size++) {
            for (; item < weight.length; item++) {
                if (weight[item] > size) {
                    totalValue[item][size] = totalValue[item - 1][size];
                } else {
                    // 装不装这个item？
                    // 不装的话直接是当前size没装这个item的最大值，装的话是没装这个item的size下的最大值加这个item的值，由此保证了这个结果确实是这个size的最大值
                    totalValue[item][size] =
                            Math.max(totalValue[item - 1][size], value[item] + totalValue[item - 1][size - weight[item]]);
                }
            }
        }
        //由于这个item表示的是前几个放以后的最大值，所以整个数组其实是会很大程度受到weight数组的顺序的影响，
        //但最后一行也就是所有item都确定过以后的结果是一定的，是最有参考价值的。
        for (int[] row : totalValue) {
            System.out.println(Arrays.toString(row));
        }
    }
}
