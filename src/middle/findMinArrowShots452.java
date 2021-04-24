package middle;

import tools.GeneralTool;

import java.util.Arrays;
import java.util.Comparator;

class findMinArrowShots452 {
    public static void main(String[] args) {
        findMinArrowShots452 t = new findMinArrowShots452();
        t.test();
    }

    private void test() {
        String[] eg = {"[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]", "[[10,16],[2,8],[1,6],[7,12]]", "[[1,2],[3,4],[5,6],[7,8]]",
                "[[1,2],[2,3],[3,4],[4,5]]", "[[1,2]]", "[[2,3],[2,3]]"};
        for (String e : eg) {
            System.out.println(findMinArrowShots(GeneralTool.getArr2(e)));
        }
    }

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(ints -> ints[0]));
        int count = 1;
        for (int i = 1; i < len; i++) {
            //有相交则不断求交集
            if (points[i - 1][1] >= points[i][0]) {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else {
                //完全不相交了就算一支箭
                count++;
            }
        }
        return count;
    }
}
