package middle;

import tools.GeneralTool;

import java.util.*;

public class mergeInterval56 {
    public static void main(String[] args) {
        mergeInterval56 t = new mergeInterval56();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1,3],[2,6],[8,10],[15,18]]", "[[1,4],[4,5]]", "", "[[1,4],[0,4]]", "[[2,2],[1,3],[3,3]]", "[[1,4],[0,0]]"};
        for (String e : eg) {
            System.out.println(Arrays.deepToString(merge(GeneralTool.getArr2(e))));
        }
    }

    public int[][] merge(int[][] intervals) {
        intervals = Arrays.stream(intervals).sorted(Comparator.comparingInt(ints -> ints[0])).toArray(int[][]::new);
        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //判断重叠
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                ret.add(intervals[i]);
            }
        }
        return ret.toArray(new int[0][0]);
    }
}
