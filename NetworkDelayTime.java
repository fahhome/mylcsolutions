package leetcode;
import java.util.*;

// Djikstra's algorithms

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxtime = 0;

        int[] distances = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[k] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distances[a] - distances[b]);

        int[] isFinal = new int[n + 1];
        for (int i = 1; i <= n; i++)
            pq.add(i);

        HashMap<Integer, List<int[]>> adjlist = new HashMap<>();

        int edges = times.length;

        for (int i = 0; i < edges; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int time = times[i][2];

            if (adjlist.containsKey(from)) {
                int[] newarr = new int[2];
                newarr[0] = to;
                newarr[1] = time;

                List<int[]> oldlist = adjlist.get(from);
                oldlist.add(newarr);

            } else {
                int[] newarr = new int[2];
                newarr[0] = to;
                newarr[1] = time;
                List<int[]> newlist = new LinkedList<>();
                newlist.add(newarr);
                adjlist.put(from, newlist);
            }
        }
        // This step is proven by Djikstra's that after n steps shortest distance to each node is found
        for (int i = 0; i < n; i++) {
            int newsetnode = pq.poll();
            isFinal[newsetnode] = 1;
            if (distances[newsetnode] == Integer.MAX_VALUE)
                return -1;
            if (distances[newsetnode] > maxtime)
                maxtime = distances[newsetnode];
            if (!adjlist.containsKey(newsetnode))
                continue;
            List<int[]> adjnodes = adjlist.get(newsetnode);
            for (int[] adjnode : adjnodes) {
                int to = adjnode[0];
                int time = adjnode[1];
                if (distances[newsetnode] + time < distances[to]) {
                    distances[to] = distances[newsetnode] + time;
                    pq.remove(to);
                    pq.add(to);
                }

            }

        }

        return maxtime;

    }
}
