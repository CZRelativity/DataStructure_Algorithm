package middle;

import java.util.ArrayList;
import java.util.List;

public class grayCode89 {
    public static void main(String[] args) {
        grayCode89 t = new grayCode89();
        t.test();
    }

    private void test() {
        int[] eg = {0, 1, 2, 3, 4};
        for (int e : eg) {
            grayCodeDbg(e);
            System.out.println(resDbg);
        }
    }

    List<String> resDbg;
    List<Integer> res;

    public List<String> grayCodeDbg(int n) {
        resDbg = new ArrayList<>();
        dfsDbg(new StringBuilder(), 0, n, 0);
        return resDbg;
    }

    public List<Integer> grayCode(int n) {
        res = new ArrayList<>();
        dfs(0, 0, n, 0);
        return res;
    }

    //！！！格雷编码，两个连续码只有一位的差异
    private void dfsDbg(StringBuilder sum, int bit, int n, int order) {
        if (bit == n) {
            resDbg.add(sum.toString());
            return;
        }
        /*
        但是格雷编码的条件决定了不能这么深搜
        两条路：1、当前位为0 左子树右子树？细节：先0决定了最后编码的第一个肯定是0
        2、当前位为1
        */
        if (order == 0) {
            dfsDbg(new StringBuilder(sum).append(0), bit + 1, n, 0);
            dfsDbg(new StringBuilder(sum).append(1), bit + 1, n, 1);
        } else {
            dfsDbg(new StringBuilder(sum).append(1), bit + 1, n, 0);
            dfsDbg(new StringBuilder(sum).append(0), bit + 1, n, 1);
        }
    }

    private void dfs(int sum, int bit, int n, int order) {
        if (bit == n) {
            res.add(sum);
            return;
        }
        if (order == 0) {
            //0->0,1
            dfs(sum, bit + 1, n, 0);
            //1->1,0
            dfs(sum + (int) Math.pow(2, bit), bit + 1, n, 1);
        } else {
            //1->0,1
            dfs(sum + (int) Math.pow(2, bit), bit + 1, n, 0);
            //0->1,0
            dfs(sum, bit + 1, n, 1);
        }
    }

}
