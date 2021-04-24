package middle;

import java.util.ArrayList;
import java.util.List;

public class subSet78 {
    public static void main(String[] args) {
        subSet78 t = new subSet78();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3}};
        for (int[] e : eg) {
            subsets(e);
            res.forEach(System.out::println);
        }
    }

    List<List<Integer>> res;

    //100%
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        form(nums, new ArrayList<>(), 0);
        return res;
    }

    private void form(int[] nums, List<Integer> list, int start) {
        //任意子集，在开头无条件添加
        res.add(list);
        for (int i = start; i < nums.length; i++) {
            /* 对拷贝使用.add()，避免对同一个引用对象调用方法
             * 每次循环以后，都调用new ArrayList<>(list)还原到栈内的初始List，避免了使用remove(),
             * 如果使用remove()来回溯的话应该是res.add(new ArrayList<>(list)) */
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            form(nums, newList, i + 1);
        }
    }
}
