package dataStructure;

public class GraphExample {

    public String[] vertexes = new String[]{"A", "B", "C", "D", "E", "F", "G"};

    public int[][] edges=new int[][]{{0, 5, 7, 0, 0, 0, 2}, {5, 0, 0, 9, 0, 0, 3}, {7, 0, 0, 0, 8, 0, 0},
            {0, 9, 0, 0, 0, 4, 0}, {0, 0, 8, 0, 0, 5, 4}, {0, 0, 0, 4, 5, 0, 6},
            {2, 3, 0, 0, 4, 6, 0}};

    public int size= edges.length;

    public String getVertex(int v){
        return vertexes[v];
    }

    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }

}
