package middle;

import tools.GeneralTool;

public class canJump55 {
    public static void main(String[] args) {
        canJump55 t = new canJump55();
        t.test();
    }

    private void test() {
        String[] eg = {"[2,3,1,1,4]", "[3,2,1,0,4]", "[1]"};
        for (String e : eg) {
            System.out.println(canJump(GeneralTool.getArr1(e)));
        }
    }

    public boolean canJump(int[] nums) {
        int cover = nums[0];
        int i = 0;
        //cover满足要求即退出，连续小于也保证了index不会溢出
        while (i < cover && cover < nums.length) {
            i++;
            //i先++,所以下面已经比较过了i==cover的情况
            cover = Math.max(cover, i + nums[i]);
        }
        //length==1的情况：[0]
        return cover >= nums.length - 1 || nums.length == 1;
    }
}
