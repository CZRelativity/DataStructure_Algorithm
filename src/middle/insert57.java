package middle;

import tools.GeneralTool;

import java.util.*;

public class insert57 {
    public static void main(String[] args) {
        insert57 t = new insert57();
        t.test();
    }

    private void test() {
        String[] intervals = {"[[1,3],[6,9]]", "[[1,2],[3,5],[6,7],[8,10],[12,16]]"};
        int[][] newInterval = {{2, 5}, {4, 8}};
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.deepToString(insert(GeneralTool.getArr2(intervals[i]), newInterval[i])));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        Collections.addAll(intervalList, intervals);
        intervalList.add(newInterval);
        intervalList.sort(Comparator.comparingInt(ints -> ints[0]));
        for (int i = 0; i < intervalList.size(); ) {
            if (i < intervalList.size() - 1) {
                int[] interval = intervalList.get(i);
                int[] nextInterval = intervalList.get(i + 1);
                if (interval[1] >= nextInterval[0]) {
                    interval[1] = Math.max(interval[1], nextInterval[1]);
                    intervalList.remove(i + 1);
                    continue;
                }
            }
            i++;
        }
        return intervalList.toArray(new int[0][0]);
    }
}
