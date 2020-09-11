package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static void main(String[] args){
        Kruskal t=new Kruskal();
        t.kruskal();
    }

    public Kruskal(){
        //暴力初始化就完事儿了
        Collections.addAll(this.vertexesList,
                "A","B","C","D","E","F","G");
        this.addEdge(2,4,5);
        this.addEdge(3,2,3);
        this.addEdge(4,3,4);
        this.addEdge(5,2,4);
        this.addEdge(6,2,5);
        this.addEdge(7,1,5);
        this.addEdge(8,4,6);
        this.addEdge(9,5,6);
        this.addEdge(10,1,2);
        this.addEdge(12,0,1);
        this.addEdge(14,0,6);
        this.addEdge(16,0,5);
    }

    List<String> vertexesList=new ArrayList<>();
    List<Edge> edgesList=new ArrayList<>();

    /**
     * 终点数组，即“在最小生成树中与这个顶点连通的最大顶点”
     * ！这个最大就单纯是顶点的下标最大
     */
    Integer[] ends;

    /**
     * 克鲁斯卡尔算法解修路问题（最小生成树）
     */
    public void kruskal(){
        //跟普里姆一样用边数做循环的终止条件
        int numEdges=0;
        int size=vertexesList.size();

        int selectEdgeIndex=0;
        Edge selectEdge;

        int v1,v2,v1End,v2End;

        //初始化终点数组
        ends=new Integer[size];
        //List直接排序
        Collections.sort(edgesList);

        while(numEdges<size-1){
            //只需要把边的集合按顺序遍历一次，中间跳过部分形成回路的边
            selectEdge=edgesList.get(selectEdgeIndex);

            v1=selectEdge.v1;
            v2=selectEdge.v2;

            v1End=getEnd(v1);
            v2End=getEnd(v2);

            if(v1End!=v2End) {
                //等于是把大end像一个链表一样接在小end后面,ends[]就像是在next，这么接的话所有新加入的结点都会一路指向最大的end
                if (v1End < v2End) {
                    ends[v1End] = v2End;
                } else{
                    ends[v2End] = v1End;
                }
                System.out.print("<"+getVertex(v1)+","+getVertex(v2)+"> ");
                numEdges++;
            }
            selectEdgeIndex++;
        }
    }

    public void addEdge(int weight,int v1,int v2){
        edgesList.add(new Edge(weight,v1,v2));
    }

    /**
     * @param v 顶点
     * @return 顶点的终点（在最小生成树中与它连通的最大顶点）
     */
    public int getEnd(int v){
        //ends数组就像一个链表，顶点的end[]就好像是next,所以终点是一直找到最后
        while(ends[v]!=null){
            v=ends[v];
        }
        //如果还没有被指向别的终点，那么自己就是终点
        return v;
    }

    public String getVertex(int v){
        return vertexesList.get(v);
    }

    /**
     * 图的边 类，不用考虑每条边的前后
     * 实现Comparable接口，用于排序
     */
    class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int weight;

        public Edge(int weight, int v1, int v2){
            this.v1=v1;
            this.v2=v2;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight-edge.weight;
        }
    }
}
