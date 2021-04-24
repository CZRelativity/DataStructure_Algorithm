package middle;

import tools.GeneralTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class canFinish207 {
    public static void main(String[] args) {
        canFinish207 t = new canFinish207();
        t.test();
    }

    private void test() {
        int[] numCourses = {4, 3, 3, 2, 2};
        String[] prerequisites = {"[[2,0],[1,0],[3,1],[3,2],[1,3]]", "[[1,0],[1,2],[0,1]]", "[[1,0],[2,0]]", "[[1,0]]", "[[1,0],[0,1]]"};
        for (int i = 0; i < numCourses.length; i++) {
            System.out.println(canFinish(numCourses[i], GeneralTool.getArr2(prerequisites[i])));
        }
    }

    //5% 哭了
    public boolean canFinishLinkedList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            preGraph.add(new ArrayList<>());
        }
        boolean[] can = new boolean[numCourses];
        LinkedList<Integer> q = new LinkedList<>();
        Arrays.fill(can, true);
        for (int[] req : prerequisites) {
            preGraph.get(req[0]).add(req[1]);
            if (can[req[0]]) {
                can[req[0]] = false;
                q.add(req[0]);
            }
        }
        boolean search = true;
        while (search) {
            search = false;
            for (int i = 0; i < q.size(); ) {
                int j = 0;
                Integer course = q.get(i);
                for (int pre : preGraph.get(course)) {
                    if (!can[pre]) {
                        break;
                    }
                    j++;
                }
                if (j == preGraph.get(course).size()) {
                    can[course] = true;
                    q.remove(course);
                    search = true;
                } else {
                    i++;
                }
            }
        }
        return q.size() == 0;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            preGraph.add(new ArrayList<>());
        }
        boolean[] can = new boolean[numCourses];
        Arrays.fill(can, true);
        for (int[] req : prerequisites) {
            can[req[0]] = false;
            preGraph.get(req[0]).add(req[1]);
        }
        boolean search = true;
        while (search) {
            search = false;
            for (int i = 0; i < numCourses; i++) {
                if (!can[i]) {
                    int j = 0;
                    for (int pre : preGraph.get(i)) {
                        if (!can[pre]) {
                            break;
                        }
                        j++;
                    }
                    if (j == preGraph.get(i).size()) {
                        can[i] = true;
                        search = true;
                    }
                }
            }
        }
        for (boolean b : can) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
