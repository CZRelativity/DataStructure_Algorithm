package Tools;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    List<List<Integer>> res = new ArrayList<>();

    //声明一个布尔数组，用来判断某个索引位置的数字是否被使用过了
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        List<Integer> preList = new ArrayList<>();
        generatePermutation(nums, 0, preList);

        return res;

    }

    /**
     * 回溯
     *
     * @param nums    给定数组
     * @param index   当前考察的索引位置
     * @param preList 先前排列好的子序列
     */
    private void generatePermutation(int[] nums, int index, List<Integer> preList) {
        //index 等于给定数组的长度时，说明一种排列已经形成，直接将其加入成员变量 res 里
        if (index == nums.length) {
            //这里需要注意java的值传递
            //此处必须使用重新创建对象的形式，否则 res 列表中存放的都是同一个引用
            res.add(new ArrayList<>(preList));
            return;
        }
//        index为几的栈就不断地往preList的第几位加，这是因为index0的栈加入之后才通过递归创建了index为1的栈
//        也正因为这个原因，index为0的栈是不会重复的，因为从来没有销毁过，而在这之上的栈是不断销毁重建的，这样才能完成全排列
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//这个for里面只有一个if
                preList.add(nums[i]);
                used[i] = true;//每一个新栈之前都放入了一个元素，并且标记了这个元素的位置
                generatePermutation(nums, index + 1, preList);
                //一定要记得回溯状态
                preList.remove(preList.size() - 1);//每回溯一次，移除preList中的最后一位元素
                used[i] = false;//为什么这里移除的标记一定是preList中最后的元素在原序中的标记？
//              因为这个栈里面移除的元素也一定是在这个栈里面之前加进去的
            }
        }
        return;
    }


}
