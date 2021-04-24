package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionLabels763 {
    public static void main(String[] args) {
        partitionLabels763 t = new partitionLabels763();
        t.test();
    }

    private void test() {
        String[] eg = {"ababcbacadefegdehijhklij"};
        for (String e : eg) {
            System.out.println(partitionLabels(e));
        }
    }

    public List<Integer> partitionLabels(String S) {
        int[] lastPosMap = new int[26];
        char[] chars = S.toCharArray();
        //记录每个字母最后出现的位置
        for (int i = 0; i < chars.length; i++) {
            lastPosMap[chars[i] - 'a'] = i;
        }
        int farthest = 0;
        int lastPart = -1;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int curLastPos = lastPosMap[chars[i] - 'a'];
            //已扫描部分所有字母出现的最远位置，动态变化
            if (curLastPos > farthest) {
                farthest = curLastPos;
            }
            //如果该部分的最远位置正好到当前下标，就可以分出来
            if (farthest == i) {
                //按题目要求每段用length来表示
                ret.add(i - lastPart);
                lastPart = i;
            }
        }
        return ret;
    }
}
