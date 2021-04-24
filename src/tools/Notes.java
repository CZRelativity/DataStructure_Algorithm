package tools;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Notes {
    public static void main(String[] args) {

    }

    private static void stream() {
        int[] intArr1 = {1, 2, 3, 4, 5};//草，最简初始化方式，new习惯了连这都忘了

        //int[] -> List<Integer>
        List<Integer> integerList1 = IntStream.of(intArr1)//先把int[]转成IntStream
                .boxed()//再把IntStream转成Stream<Integer>封装流
                .collect(Collectors.toList());//再把Stream<Integer>转成List<Integer>

        //int[] -> Integer[]
        Integer[] integerArr1 = IntStream.of(intArr1)//先把int[]转成IntStream
                .boxed()//再把IntStream转成Stream<Integer>封装流
                .toArray(Integer[]::new);//用toArray方法，传入IntFunction<A[]> generator

        //List<Integer> -> int[]
        int[] intArr2 = integerList1.stream()//先把List<Integer>转成Stream<Integer>
                .mapToInt(Integer::intValue)//把Integer流映射到intStream
                .toArray();//把IntStream转成int[]

        //Integer[] -> int[]
        int[] intArr3 = Arrays.stream(integerArr1)//把Integer[]转成Stream<Integer>
                .mapToInt(Integer::intValue)//把Integer流映射到intStream(核心方法stream.mapToInt())
                .toArray();//把IntStream转成int[]

        //List<Integer> -> Integer[]
        Integer[] integerArr2 = integerList1.toArray(new Integer[0]);

        //Integer[] -> List<Integer>
        List<Integer> integerList2 = Arrays.asList(integerArr2);
    }

    /* jdk1.8 compute方法等 */
    private static void hashmap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        //两种方法实现统计数组中每个元素的出现次数
        int[] nums = new int[10];
        //① Map.compute()
        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }
        //② stream
        Map<Integer, Integer> map2 = Arrays.stream(nums).boxed().
                collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    }

    private static void treemap() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    }
}
