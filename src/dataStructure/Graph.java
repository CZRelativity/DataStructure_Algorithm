package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        String[] vertexes1 = new String[]{"A", "B", "C", "D", "E",};
        int[][] edges1 = {{0, 1, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 1, 0, 0, 0}};
        String[] vertexes2 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8",};
        int[][] edges2 = new int[8][8];
        Graph t1 = new Graph(vertexes1, edges1);
        Graph t2 = new Graph(vertexes2, edges2);

        t1.dfs();
        t1.bfs();

        t2.addEdge(0, 1, 1);
        t2.addEdge(0, 2, 1);
        t2.addEdge(1, 3, 1);
        t2.addEdge(1, 4, 1);
        t2.addEdge(3, 7, 1);
        t2.addEdge(4, 7, 1);
        t2.addEdge(2, 5, 1);
        t2.addEdge(2, 6, 1);
        t2.addEdge(5, 6, 1);

        t2.dfs();
        t2.bfs();
    }


    /**
     * 顶点表
     */
    List<String> vertexList;

    /**
     * 邻接数组
     */
    int[][] edges;

    int numEdges;
    /**
     * 访问标记
     */
    boolean[] visited;

    public Graph(int numVertex) {
        vertexList = new ArrayList<>();
        edges = new int[numVertex][numVertex];
        numEdges = 0;
    }

    public Graph(String[] vertexes, int[][] edges) {
        vertexList = new ArrayList<>();
        // Collections.addAll()方法代替遍历数组add，有点怕空指针，不要忘了先定义List（比Arrays.asList()方法优先级更高，
        // 后者得到的不是常见的java.util.ArrayList
        // 而是java.util.Arrays.ArrayList，不能add和remove）
        Collections.addAll(vertexList, vertexes);
        this.edges = edges;
        for (int[] row : edges) {
            for (int i : row) {
                if (i != 0) {
                    numEdges++;
                }
            }
        }
    }

    /**
     * DepthFirstSearch 图的深度优先搜索（遍历）
     */
    public void dfs() {
        //用来记录顶点是否被访问过
        visited = new boolean[getNumVertex()];
        //1、访问初始结点,并标记其为已访问，这边直接用了第一个结点
        System.out.print(getVertexByIndex(0) + "->");
        visited[0] = true;
        onDFS(0);
        System.out.println();
    }

    /**
     * DFS 递归
     *
     * @param vertexIndex 顶点的下标，表示从该顶点出发搜索邻接节点
     */
    private void onDFS(int vertexIndex) {
        //这里起始下标是1，因为确实不用再考虑首个顶点了
        //2、直接从第二节结点（下标1）开始查找当前结点的第一个邻接节点（在邻接数组中）
        for (int i = 1; i < getNumVertex(); i++) {
            if (edges[vertexIndex][i] != 0) {
                //4、如果当前顶点没有被访问过的话，标记，输出，并从其出发寻找递归继续寻找邻接结点
                if (!visited[i]) {
                    visited[i] = true;
                    System.out.print(getVertexByIndex(i) + "->");
                    onDFS(i);
                }
            }
        }
        //3、没有则退回上一栈
    }

    /**
     * BroadFirstSearch 图的广度优先搜索（遍历），先进先出，同样使用队列
     */
    public void bfs() {
        visited = new boolean[getNumVertex()];
        //借助LinkedList的方法addFirst/Last，removeFirst/Last方法，先进先出的队列结构和先进后出的堆栈结构均可实现
        //*LinkedList本身是Queue接口的实现类，其无参add()方法就是放在最后，无参remove()方法就是取最前
        LinkedList<Integer> vertexList = new LinkedList<>();
        int vertexIndex;
        System.out.print(getVertexByIndex(0) + "->");
        visited[0] = true;
        //放和取的位置相反就是队列，这里是为了按照访问顺序去查找邻接顶点
        vertexList.add(0);
        //队列为空则结束循环
        while (!vertexList.isEmpty()) {
            vertexIndex = vertexList.remove();
            //大体相同，不过优先将一个顶点的所有邻接点输出，并只是入队列，再按访问顺序去找下一个点的所有临界点
            for (int i = 1; i < getNumVertex(); i++) {
                if (edges[vertexIndex][i] != 0) {
                    if (!visited[i]) {
                        System.out.print(getVertexByIndex(i) + "->");
                        visited[i] = true;
                        vertexList.addLast(i);
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * 输出邻边数组
     */
    public void showEdges() {
        for (int[] row : edges) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 根据下标返回顶点的对应值
     *
     * @param i 下标
     * @return 顶点值
     */
    public String getVertexByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回边（edge）的数目
     *
     * @return 边数
     */
    public int getNumEdges() {
        return numEdges;
    }

    /**
     * 返回顶点（vertex）的数目
     *
     * @return 顶点数
     */
    public int getNumVertex() {
        return edges.length;
    }

    /**
     * 添加顶点
     *
     * @param vertex 顶点值
     */
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边及其权重
     *
     * @param v1     顶点1下标
     * @param v2     顶点2下标
     * @param weight 权重
     */
    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numEdges++;
    }
}
