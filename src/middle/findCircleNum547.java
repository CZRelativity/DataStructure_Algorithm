package middle;

import tools.GeneralTool;

public class findCircleNum547 {
    public static void main(String[] args) {
        findCircleNum547 t = new findCircleNum547();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1,1,0],[1,1,0],[0,0,1]]", "[[1,0,0],[0,1,0],[0,0,1]]",
                "[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]"};
        for (String e : eg) {
            System.out.println(findCircleNum(GeneralTool.getArr2(e)));
        }
    }

    boolean[] visited;
    int count;

    //99.8%
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        visited = new boolean[len];
        count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, isConnected);
            }
        }
        return count;
    }

    private void bfs(int start, int[][] isConnect) {
        for (int i = 0; i < isConnect.length; i++) {
            if (i != start && !visited[i] && isConnect[start][i] == 1) {
                visited[i] = true;
                bfs(i, isConnect);
            }
        }
    }
}
