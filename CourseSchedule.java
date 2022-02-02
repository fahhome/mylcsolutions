package leetcode;
import java.util.*;

public class CourseSchedule {

    public boolean isCycle(int curNode,
            HashMap<Integer, List<Integer>> adjlist, int[] visited, int[] checked) {

        if (checked[curNode] == 1)
            return false;

        boolean res = false;
        if (!adjlist.containsKey(curNode))
            return false;
        for (Integer child : adjlist.get(curNode)) {

            if (visited[child] == 1) // Only if there is a loop in the current flow of dfs then it is a cycle . 
                return true;

            visited[child] = 1;

            res = isCycle(child, adjlist, visited, checked);

            // Without the next two lines not all cases pass
            if (res == true)
                return res;

            visited[child] = 0;

        }

        if (res == false)
            checked[curNode] = 1;

        return res;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] visited = new int[numCourses];
        int[] checked = new int[numCourses];

        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        int totedges = prerequisites.length;

        for (int i = 0; i < totedges; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            if (adjlist.containsKey(from)) {
                List<Integer> curlist = adjlist.get(from);
                curlist.add(to);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(to);
                adjlist.put(from, list);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            boolean res = isCycle(i, adjlist, visited, checked);
            if (res == true)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        
    }
}
