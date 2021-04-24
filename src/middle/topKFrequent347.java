package middle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class topKFrequent347 {
    public static void main(String[] args) {
        topKFrequent347 t = new topKFrequent347();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 1, 1, 2, 2, 3},};
        int[] egK = {2,};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(Arrays.toString(topKHeap(eg[i], egK[i])));
        }
    }

    //对象排序几种方法 1、传统排序变形 2、二叉排序树 3、小顶堆大顶堆（PriorityQueue） 4、stream，yyds
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            //BiFunction,根据输入的两个参数,可以写一条返回value的语句
            frequentMap.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = frequentMap.entrySet();
        int[] sort = entries.stream().sorted((entry1, entry2)
                -> entry2.getValue() - entry1.getValue()).mapToInt(Map.Entry::getKey).toArray();
        return Arrays.copyOf(sort, k);
    }

    //小顶堆学习，你可以按任意顺序返回答案
    private int[] topKHeap(int[] nums, int k) {
        Map<Integer, Integer> counter = Arrays.stream(nums).boxed().
                /* 第三个参数定义了如果value冲突时的解决办法（即第二次写入同一个key值），具有两个天然的参数（value1,value2）
                 * 使用方法引用自动传入了这两个参数，lambda写法是(value1,value2)->value1+value2，
                 * 同样的原理也可以设置要留下哪个value，比如(value1,value2)->value1
                 * Function接口：function包下有很多种，比如Function接口是接受一个参数，返回一个参数
                 * BiFunction接受两个参数，返回一个参数(BinaryFunction)，
                 * 必须要按照接口类型的要求传入参数，虽然不一定要用到传入的参数 */
                        collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        //小顶堆，(key1,key2)->counter.get(key1)-counter.get(key2) ~ Comparator.compareInt()
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(counter::get));
        //heap.addAll(counter.keySet());
        for (Integer key : counter.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (heap.size() == k && counter.get(key) > counter.get(heap.peek())) {
                heap.poll();
                heap.add(key);
            }
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }
}
