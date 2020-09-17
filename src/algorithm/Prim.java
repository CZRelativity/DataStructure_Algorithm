package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prim {

    public static void main(String[] args) {
        Prim t = new Prim(new String[]{"A", "B", "C", "D", "E", "F", "G"},
                new int[][]{{0, 5, 7, 0, 0, 0, 2}, {5, 0, 0, 9, 0, 0, 3}, {7, 0, 0, 0, 8, 0, 0},
                        {0, 9, 0, 0, 0, 4, 0}, {0, 0, 8, 0, 0, 5, 4}, {0, 0, 0, 4, 5, 0, 6},
                        {2, 3, 0, 0, 4, 6, 0}});

        t.prim();
    }

    public Prim(String[] vertexes, int[][] edges) {
        if (vertexes.length == edges.length) {
            Collections.addAll(vertexList, vertexes);
            this.edges = edges;
        } else {
            System.out.println("初始化对象失败，请检查顶点和邻接矩阵是否匹配！");
        }
    }

    /**
     * 图的邻接数组
     */
    int[][] edges;
    List<String> vertexList = new ArrayList<>();
    /**
     * 访问标记
     * 用一个放下标的List倒是确实可以减少一些遍历次数
     */
    boolean[] visited;

    /**
     * 普里姆算法解修路问题（最小生成树）
     */
    public void prim() {

        int roads = 0;
        int size = vertexList.size();

        visited = new boolean[size];
        //同样设下标0（A）为起始点
        visited[0] = true;

        //最少的边数连接所有的N个顶点，一定有N-1条边
        while (roads < size - 1) {

            //由于要找最小的weight,初始weight一定要比所有weight都大
            int weightSelect = 99;
            int fromSelect = 0, toSelect = 0;

            //外循环遍历的是已访问的标记数组，可从已修通的所有顶点出发找下一个顶点
            for (int from = 0; from < size; from++) {
                if (visited[from]) {

                    //内循环遍历的是已访问的点在邻接数组上的一行，可以遍历到这个点的所有边
                    for (int to = 1; to < size; to++) {
                        //两顶点之间边存在，且目标点没有访问过，符合前两项且这条边权值最小
                        if (edges[from][to] != 0 && !visited[to] && edges[from][to] < weightSelect) {
                            //记下权值用于遍历中继续比较
                            weightSelect = edges[from][to];
                            //记下这条边的起始顶点和目标顶点
                            fromSelect = from;
                            toSelect = to;
                        }
                    }
                }

            }

            System.out.println(vertexList.get(fromSelect) + " -> " + vertexList.get(toSelect));
            roads++;
            visited[toSelect] = true;

        }
    }

    public void addEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }

}
