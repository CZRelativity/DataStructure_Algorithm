package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra t = new Dijkstra(new String[]{"A", "B", "C", "D", "E", "F", "G"},
                new int[][]{{0, 5, 7, 0, 0, 0, 2}, {5, 0, 0, 9, 0, 0, 3}, {7, 0, 0, 0, 8, 0, 0},
                        {0, 9, 0, 0, 0, 4, 0}, {0, 0, 8, 0, 0, 5, 4}, {0, 0, 0, 4, 5, 0, 6},
                        {2, 3, 0, 0, 4, 6, 0}});

        t.dijkstra(6, 3);
    }

    public Dijkstra(String[] vertexes, int[][] edges) {
        if (vertexes.length == edges.length) {
            this.edges = edges;
            Collections.addAll(this.vertexList, vertexes);
            this.size = edges.length;
        } else {
            System.out.println("初始化对象失败，请检查顶点和邻接矩阵是否匹配！");
        }
    }

    private List<String> vertexList = new ArrayList<>();
    private int[][] edges;
    private int size;

    /**
     * 迪杰斯特拉算法 解图的最短路径问题
     *
     * @param startVertex  起始顶点
     * @param targetVertex 目标顶点
     */
    public void dijkstra(int startVertex, int targetVertex) {
        //记录下已经求到了最短路径的顶点
        boolean[] solved = new boolean[size];
        //记录依照最短路径到达当前顶点的前序顶点
        int[] preVertex = new int[size];
        //记录从出发点到各顶点的路径长度，并随循环更新，最终可求得到各顶点的最短路径
        int[] distance = new int[size];
        //根据邻接数组，从起始点出发，初始化distance数组和preVertex数组
        for (int i = 0; i < size; i++) {
            if (edges[startVertex][i] == 0) {
                //由于往后是直接用“<”来查找并更新最短路径，所以初始化时候把所有到不了的点先设成最大值，以免原值为0的时候对“<”造成干扰
                distance[i] = 999;
            } else {
                //能到的点先把距离放进数组，如果以后有到这个点更短的路径再更新
                distance[i] = edges[startVertex][i];
                if (i != startVertex) {
                    //初始化的时候，都是从起始点直接到的，故前一个顶点是起始点
                    preVertex[i] = startVertex;
                }
            }
        }

        solved[startVertex] = true;

        int minDistance, minVertex = 99;
        while (true) {
            //每一次循环都必须把最小路径长度初始化，这样跟
            minDistance = 999;
            //为什么一个顶点在一次遍历里路径最短就一定是最短路径了呢，因为这说明从顶点经过其他点再到这个点路径都一定更长
            for (int i = 0; i < size; i++) {
                if (!solved[i] && distance[i] < minDistance) {
                    minDistance = distance[i];
                    minVertex = i;
                }
            }
            //标记已找到最短路径
            solved[minVertex] = true;
            //如果已经找到目标点的最短路径就退出循环
            if (minVertex == targetVertex) {
                break;
            }
            //遍历从才找到最短路径的点出发，能够到达的顶点，就有可能从一个顶点最短得到其他顶点的最短路径
            for (int j = 0; j < size; j++) {
                //比现在的路径短，或者现在直接还没路径，就更新距离数组，下次循环一起比较，同时更新前顶点数组
                if (!solved[j] && edges[minVertex][j] != 0 &&
                        edges[minVertex][j] + minDistance < distance[j]) {
                    distance[j] = edges[minVertex][j] + minDistance;
                    preVertex[j] = minVertex;
                }
            }
        }

        //输出结果是从目标点通过前顶点数组倒着一直到起始点的，所以用了StringBuilder
        int v = targetVertex;
        StringBuilder result = new StringBuilder();
        while (v != startVertex) {
            result.append(vertexList.get(v)).append(" - ");
            v = preVertex[v];
        }
        System.out.println(result.append(vertexList.get(startVertex)).reverse());
    }

}
