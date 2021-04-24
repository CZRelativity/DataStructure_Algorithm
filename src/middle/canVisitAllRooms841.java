package middle;

import tools.GeneralTool;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class canVisitAllRooms841 {
    public static void main(String[] args) {
        canVisitAllRooms841 t = new canVisitAllRooms841();
        t.test();
    }

    private void test() {
        String[] eg = { "[[1,3],[3,0,1],[2],[0]]"};
        for (String e : eg) {
            System.out.println(canVisitAllRooms(GeneralTool.getList2(e)));
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        Deque<Integer> keyQ = new LinkedList<>();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        int countVisit = 1;
        for (int i : rooms.get(0)) {
            if (!visited[i]) {
                keyQ.add(i);
            }
        }
        while (!keyQ.isEmpty()) {
            Integer key = keyQ.remove();
            if (!visited[key]) {
                visited[key] = true;
                countVisit++;
                for (int i : rooms.get(key)) {
                    if (!visited[i]) {
                        keyQ.add(i);
                    }
                }
            }
        }
        return countVisit == size;
    }
}
