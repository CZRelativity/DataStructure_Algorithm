package middle;

import tools.GeneralTool;

import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting994 {
    public static void main(String[] args) {
        orangesRotting994 t = new orangesRotting994();
        t.test();
    }

    private void test() {
        String[] eg = {"[[2,1,1],[1,1,0],[0,1,1]]", "[[2,1,1],[0,1,1],[1,0,1]]", "[[0,2]]"};
        for (String e : eg) {
            System.out.println(orangesRotting(GeneralTool.getArr2(e)));
        }
    }

    int[][] grid;
    int m, n;

    //98%
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q1.add(new int[]{i, j});
                }
            }
        }
        return bfs(q1, q2, 0);
    }

    private int bfs(Queue<int[]> q, Queue<int[]> qNext, int level) {
        while (!q.isEmpty()) {
            int[] pos = q.remove();
            //pos=new int[]{i,j} 数组存储坐标
            if (pos[0] + 1 < m && grid[pos[0] + 1][pos[1]] == 1) {
                grid[pos[0] + 1][pos[1]] = 2;
                qNext.add(new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[0] - 1 >= 0 && grid[pos[0] - 1][pos[1]] == 1) {
                grid[pos[0] - 1][pos[1]] = 2;
                qNext.add(new int[]{pos[0] - 1, pos[1]});
            }
            if (pos[1] + 1 < n && grid[pos[0]][pos[1] + 1] == 1) {
                grid[pos[0]][pos[1] + 1] = 2;
                qNext.add(new int[]{pos[0], pos[1] + 1});
            }
            if (pos[1] - 1 >= 0 && grid[pos[0]][pos[1] - 1] == 1) {
                grid[pos[0]][pos[1] - 1] = 2;
                qNext.add(new int[]{pos[0], pos[1] - 1});
            }
        }
        if (!qNext.isEmpty()) {
            return bfs(qNext, q, level + 1);
        } else {
            //递归结束，判断是否存在永不腐烂
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return level;
        }
    }
}
