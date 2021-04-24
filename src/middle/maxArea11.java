package middle;

class maxArea11 {
    public static void main(String[] args) {
        maxArea11 t = new maxArea11();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {1, 1,},
                {4, 3, 2, 1, 4}, {1, 2, 1}};
        for (int[] e : eg) {
            System.out.println(maxArea(e));
        }
    }

    //时间20%
    public int solveOriginal(int[] height) {
        int length = height.length;
        int water = 0;
        for (int i = 0; i < length; i++) {
            int extend = 1, curWater;
            if (height[i] != 0) {
                while (i - extend > -1 || i + extend < length) {
                    if ((i - extend > -1 && height[i - extend] >= height[i]) ||
                            (i + extend < length && height[i + extend] >= height[i])) {
                        curWater = height[i] * extend;
                        if (curWater > water) {
                            water = curWater;
                        }
                    }
                    extend++;
                }
            }
        }
        return water;
    }

    //时间99%
    public int solveDoublePointer(int[] height) {
        int length = height.length;
        int water = 0;
        int left = 0, right = length - 1;
        while (left != right) {
            int leftHeight, rightHeight, curWater;
            leftHeight = height[left];
            rightHeight = height[right];
            if (leftHeight > rightHeight) {
                curWater = rightHeight * (right - left);
                right--;
            } else {
                curWater = leftHeight * (right - left);
                left++;
            }
            if (curWater > water) {
                water = curWater;
            }
        }
        return water;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max,
                    Math.min(height[left], height[right]) *
                            (right - left));
            //不是length，三个点中间只有2段
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}