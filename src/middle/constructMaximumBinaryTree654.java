package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

class constructMaximumBinaryTree654 {
    public static void main(String[] args) {
        constructMaximumBinaryTree654 t = new constructMaximumBinaryTree654();
        t.test();
    }

    private void test() {
        int[][] eg = {{}, {3, 2, 1, 6, 0, 5}, {3, 2, 1}};
        for (int[] e : eg) {
            TreeNode root = constructMaximumBinaryTree(e);
            TreeNodeTool.outBfBt(root);
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMaxBT(nums, 0, nums.length - 1);
    }

    private TreeNode getMaxBT(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            //注意不要把下标直接带进去
            return new TreeNode(nums[left]);
        }
        int maxIndex = getMaxIndexOfRange(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = getMaxBT(nums, left, maxIndex - 1);
        root.right = getMaxBT(nums, maxIndex + 1, right);
        return root;
    }

    //封装成方法时间28%，额外创建方法栈需要花费时间，不封装99% 虽然只差1mm
    private int getMaxIndexOfRange(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

//    private void quickSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mark = right;
//        for (int i = left; i < mark; ) {
//            if (nums[i] >= nums[mark]) {
//                for (int j = i; j < mark; j++) {
//                    swap(nums, j, j + 1);
//                }
//                mark--;
//            } else {
//                i++;
//            }
//        }
//        quickSort(nums, left, mark - 1);
//        quickSort(nums, mark + 1, right);
//    }
//
//    private void bubbleSort(int[] nums) {
//        for (int i = nums.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }
//    }
//
//    private void swap(int[] nums, int i1, int i2) {
//        int temp = nums[i1];
//        nums[i1] = nums[i2];
//        nums[i2] = temp;
//    }
}
