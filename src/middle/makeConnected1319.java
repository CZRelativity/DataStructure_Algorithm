package middle;

import tools.GeneralTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class makeConnected1319 {
    public static void main(String[] args) {
        makeConnected1319 t = new makeConnected1319();
        t.test();
    }

    private void test() {
        int[] n = {4, 6, 6, 5, 11,};
        String[] eg = {"[[0,1],[0,2],[1,2]]", "[[0,1],[0,2],[0,3],[1,2],[1,3]]",
                "[[0,1],[0,2],[0,3],[1,2]]", "[[0,1],[0,2],[3,4],[2,3]]",
                "[[1,4],[0,3],[1,3],[3,7],[2,7],[0,1],[2,4],[3,6],[5,6],[6,7],[4,7],[0,7],[5,7]]"};
        for (int i = 0; i < n.length; i++) {
            System.out.println(makeConnected(n[i], GeneralTool.getArr2(eg[i])));
        }
    }

    //创建泛型数组反正是挺扯的
    List<List<Integer>> connect;
    boolean[] visited;
    int count;

    public int makeConnected(int n, int[][] connections) {
        connect = new ArrayList<>();
        int len = connections.length;
        if (len + 1 < n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            connect.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            connect.get(connection[0]).add(connection[1]);
            connect.get(connection[1]).add(connection[0]);
        }
        visited = new boolean[n];
        count = 1;
        /* 我的思路：只有一个起始点算进count，其他起始点不算进count，算能够连到的总点数，用n去减,就是还需要边去连的点数
         * 更简单的思路：每次起始算count，所有单独的起始点i个需要i-1条边连接
         * 我意识到我的思路也是没问题的，只是图的连通两个点对应的结构里一定都要添加！ */
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        return n - count;
    }

    private void dfs(int start) {
        for (int i : connect.get(start)) {
            if (!visited[i]) {
                if (!visited[start]) {
                    visited[start] = true;
                }
                visited[i] = true;
                dfs(i);
                count++;
            }
        }
    }
}
