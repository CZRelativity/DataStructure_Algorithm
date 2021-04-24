package middle;

import tools.GeneralTool;

import java.util.*;

public class kClosest973 {

    public static void main(String[] args) {
        kClosest973 t = new kClosest973();
        t.test();
    }

    private void test() {
        String[] points = {"[[-95,76],[17,7],[-55,-58],[53,20],[-69,-8],[-57,87],[-2,-42],[-10,-87],[-36,-57],[97,-39],[97,49]]", "[[1,3],[-2,2]]", "[[3,3],[5,-1],[-2,4]]"};
        int[] K = {5, 1, 2};
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.deepToString(kClosest(GeneralTool.getArr2(points[i]), K[i])));
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        Map<Integer, Integer> pointDistanceMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            pointDistanceMap.put(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }
        //倒序
        PriorityQueue<Map.Entry<Integer, Integer>> maxTopHeap = new PriorityQueue<>
                ((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        for (Map.Entry<Integer, Integer> entry : pointDistanceMap.entrySet()) {
            if (maxTopHeap.size() == K) {
                if(maxTopHeap.peek().getValue()<entry.getValue()){
                    continue;
                }
                maxTopHeap.poll();
            }
            maxTopHeap.add(entry);
        }
        List<int[]> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maxTopHeap) {
            ret.add(points[entry.getKey()]);
        }
        return ret.toArray(new int[0][0]);
    }
}
