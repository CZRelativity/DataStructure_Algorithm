package middle;

import tools.GraphNode;
import tools.GraphTool;

import java.util.*;

public class cloneGraph {
    public static void main(String[] args) {
        cloneGraph t = new cloneGraph();
        t.test();
    }

    private void test() {
        String eg = "[[2,4],[1,3],[2,4],[1,3]]";
        GraphNode graphNode = GraphTool.buildGraph(eg);
        GraphNode clone = cloneGraph(graphNode);
        GraphTool.outGraph(graphNode);
        GraphTool.outGraph(clone);
    }

    public GraphNode cloneGraph(GraphNode node) {
        HashMap<GraphNode, GraphNode> old2NewMap = new HashMap<>();
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            GraphNode cur = q.remove();
            old2NewMap.put(cur, new GraphNode(cur.val));
            for (GraphNode n : cur.neighbors) {
                if (!old2NewMap.containsKey(n)) {
                    q.add(n);
                }
            }
        }
        for (GraphNode key : old2NewMap.keySet()) {
            List<GraphNode> neighbors = new ArrayList<>();
            for (GraphNode n : key.neighbors) {
                neighbors.add(old2NewMap.get(n));
            }
            old2NewMap.get(key).neighbors = neighbors;
        }
        return old2NewMap.get(node);
    }
}
