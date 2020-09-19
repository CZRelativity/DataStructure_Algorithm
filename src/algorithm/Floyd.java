package algorithm;

import data_structure.GraphExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Floyd extends GraphExample {

    public static void main(String[] args) {

        Floyd t = new Floyd();

        t.floyd();

        t.show();

        t.showShortestPath(2, 3);
        t.showShortestPath(0, 3);

    }

    public Floyd() {
        if (vertexes.length == edges.length) {
            Collections.addAll(this.vertexList, vertexes);
        } else {
            System.out.println("初始化对象失败，请检查顶点和邻接矩阵是否匹配！");
        }
    }

    private List<String> vertexList = new ArrayList<>();

    int[][] preV = new int[size][size];

    public void floyd() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                preV[i][j] = i;
            }
        }

        for (int midV = 0; midV < size; midV++) {
            int e1, e2, e12;

            for (int v1 = 0; v1 < size - 1; v1++) {
                e1 = edges[midV][v1];
                if (e1 != 0) {
                    for (int v2 = v1 + 1; v2 < size; v2++) {
                        e2 = edges[midV][v2];
                        e12 = edges[v1][v2];
                        if (e2 != 0 && (e12 == 0 || e1 + e2 < e12)) {
                            addEdge(v1, v2, e1 + e2);
                            preV[v1][v2] = midV;
                            preV[v2][v1] = midV;
                        }
                    }
                }
            }
        }
    }

    public void show() {
        for (int[] row : edges) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
        System.out.print("  ");

        for (int i = 0; i < size; i++) {
            System.out.print(" " + getVertex(i));
        }
        System.out.println();

        for (int j = 0; j < size; j++) {
            System.out.print(getVertex(j) + "  ");
            for (int v : preV[j]) {
                System.out.print(getVertex(v) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showShortestPath(int startV, int endV) {

        System.out.println("从" + getVertex(startV) + "到" + getVertex(endV) + "的最短路径为: ");

        int mid = preV[startV][endV];

        StringBuilder result = new StringBuilder(getVertex(endV));

        while (mid != startV) {
            result.append(" >- ").append(getVertex(mid));
            mid = preV[startV][mid];
        }

        result.append(" >- ").append(getVertex(startV));

        System.out.println(result.reverse().toString());
        System.out.println("长度：" + edges[startV][endV]);

    }
}
