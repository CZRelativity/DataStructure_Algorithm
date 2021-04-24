package easy;

public class canPlaceFlowers605 {
    public static void main(String[] args) {
        canPlaceFlowers605 t = new canPlaceFlowers605();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 0, 0}};
        for (int[] e : eg) {
            System.out.println(canPlaceFlowers(e));
        }
    }

    /* 贪心：由于只有1/0，不存在权重
    所以在任何一个位置，能放花都比不放要好？ */
    public int canPlaceFlowers(int[] flowerbed) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if (i == flowerbed.length - 1 || flowerbed[i + 1] != 1) {
                count++;
                i++;
            }
        }
        return count;
    }
}
