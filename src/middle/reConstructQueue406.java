package middle;

import tools.GeneralTool;

import java.util.*;

class reConstructQueue406 {
    public static void main(String[] args) {
        reConstructQueue406 t = new reConstructQueue406();
        t.test();
    }

    private void test() {
        String[] eg = {"[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]",
                "[[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]"};
        for (String e : eg) {
            System.out.println(Arrays.deepToString(reconstructQueue(GeneralTool.getArr2(e))));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        /* 我的思路，依次放先放满足条件的最小的
         * 条件：one[1]<=当前索引i
         * 有问题，不能完全满足，one[1]的定义
         *
         * dalao的思路，按one[0]升序，one[1]降序排序
         * 然后按顺序从最小开始直接放，one[1]就是他在
         * 注意：剩余格子中放的索引，也就是说假如现在还剩
         * 1,3,5号位，从剩余格子来看他们是0,1,2
         * 这样保证了我的[6,1]放在剩余的1，实际的3号位以后
         * 后面一定有一个大于等于6的（身高正序）放在剩余的0号位
         * 也就是6的前面*/

//        int pqListSize = 0;
//        for (int[] one : people) {
//            pqListSize = Math.max(pqListSize, one[1]);
//        }
//        pqListSize++;
//        List<PriorityQueue<int[]>> pqList = new ArrayList<>();
//        for (int i = 0; i < pqListSize; i++) {
//            pqList.add(new PriorityQueue<>(Comparator.comparingInt(ints -> ints[0])));
//        }
//        for (int[] one : people) {
//            pqList.get(one[1]).add(one);
//        }
//        List<int[]> res = new ArrayList<>();
//        while (res.size() < people.length) {
//            int minList = -1, min = Integer.MAX_VALUE;
//            for (int i = 0; i <= res.size() && i < pqListSize; i++) {
//                int[] peek = pqList.get(i).peek();
//                if (peek != null && peek[0] < min) {
//                    min = peek[0];
//                    minList = i;
//                }
//            }
//            res.add(pqList.get(minList).poll());
//        }
//        return res.toArray(new int[0][0]);

        int peopleLen = people.length;
        int[][] ret = new int[peopleLen][];
//        boolean[] done = new boolean[peopleLen];
        Arrays.sort(people, (one1, one2) -> {
            //compare方法和Comparator超好配合，交换参数顺序返回就是倒序了
            int compareHeight = Integer.compare(one1[0], one2[0]);
            if (compareHeight == 0) {
                return Integer.compare(one2[1], one1[1]);
            } else {
                return compareHeight;
            }
        });
        List<Integer> leftIndexList = new ArrayList<>();
        for (int i = 0; i < peopleLen; i++) {
            leftIndexList.add(i);
        }
        for (int[] one : people) {
            //ArrayList.remove()唯一一个元素又不会报错了？
            Integer i = leftIndexList.remove(one[1]);
            ret[i] = one;
        }
//        for (int[] one : people) {
//            int leftIndex = -1;
//            for (int i = 0; i < peopleLen; i++) {
//                if (!done[i]) {
//                    leftIndex++;
//                    if (leftIndex == one[1]) {
//                        ret[i] = one;
//                        done[i] = true;
//                        break;
//                    }
//                }
//            }
//        }
        return ret;
    }
}