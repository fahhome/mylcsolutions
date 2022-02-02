package leetcode;
import java.util.*;


// You can use DFS or Djikstra for this problem but not BFS
class networkDelayTimeMySoln {

    int maxTime;

    public void dfs(int src, int[] minTimeReached, HashMap<Integer, List<int[]>> adjacencyList, int timeOfVisit) {

        if (timeOfVisit < minTimeReached[src])
            minTimeReached[src] = timeOfVisit;

        if (!adjacencyList.containsKey(src))
            return;

        for (int[] adjNode : adjacencyList.get(src)) {
            // Add a if condition to avoid loops
            if (timeOfVisit + adjNode[1] < minTimeReached[adjNode[0]])
                dfs(adjNode[0], minTimeReached, adjacencyList, timeOfVisit + adjNode[1]);
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        maxTime = 0;
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for (int[] edge : times) {
            int src = edge[0];
            int dest = edge[1];
            int time = edge[2];

            if (adjacencyList.containsKey(src)) {
                adjacencyList.get(src).add(new int[] { dest, time });
            } else {
                List<int[]> adjNodes = new LinkedList<>();
                adjNodes.add(new int[] { dest, time });
                adjacencyList.put(src, adjNodes);
            }
        }

        int[] minTimeReached = new int[n + 1];
        Arrays.fill(minTimeReached, Integer.MAX_VALUE);

        dfs(k, minTimeReached, adjacencyList, 0);

        for (int i = 1; i <= n; i++) {
            if (minTimeReached[i] == Integer.MAX_VALUE)
                return -1;

            if (minTimeReached[i] > maxTime)
                maxTime = minTimeReached[i];
        }

        return maxTime;

    }
}
