package leetcode;
import java.util.*;

// Modified Djikstra's Algorithm
public class MinimumCostToReachDestinationWithinMaxTimePQ {

    static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int ans = Integer.MAX_VALUE;
        int n = passingFees.length;

        int[] distances = new int[n];
        int[] times = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(times, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        int[][] adjmatrix = new int[n][n];
        int noedges = edges.length;

        for (int i = 0; i < noedges; i++) {
            adjmatrix[edges[i][0]][edges[i][1]] = edges[i][2];
            adjmatrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        distances[0] = passingFees[0];
        times[0] = 0;

        pq.add(new int[]{0,passingFees[0],0});

        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int curvertex = front[0];
            int curcost = front[1];
            int curtime = front[2];

            if (curvertex == n - 1 && curtime <= maxTime) {
                if (curcost < ans) {
                    ans = curcost;
                    break;
                }
            }else{

                for (int i = 0; i < n; i++) {

                    if(i != n-1){
                        if (i != curvertex && adjmatrix[curvertex][i] > 0) {
                            if(distances[i] > distances[curvertex] + passingFees[i]){
                                distances[i] = distances[curvertex] + passingFees[i];
                                times[i] = curtime + adjmatrix[curvertex][i];
                                pq.add(new int[] { i, curcost + passingFees[i], curtime + adjmatrix[curvertex][i] });
                            }else if(times[i] > curtime + adjmatrix[curvertex][i]){
                                times[i] = curtime + adjmatrix[curvertex][i];
                                pq.add(new int[] { i, curcost + passingFees[i], curtime + adjmatrix[curvertex][i] });
                            }
                            
                        }
                    }else{

                        if(i != curvertex && adjmatrix[curvertex][i] > 0 && curtime + adjmatrix[curvertex][i] <= maxTime )
                            pq.add(new int[] { i, curcost + passingFees[i], curtime + adjmatrix[curvertex][i] });

                    }
                    
                }

            }
        }
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        int maxTime = 25;
        int[][] edges = { { 0, 1, 10 }, { 1, 2, 10 }, { 2, 5, 10 }, { 0, 3, 1 }, { 3, 4, 10 }, { 4, 5, 15 } };
        int[] passingFees = { 5, 1, 2, 20, 20, 3 };

        System.out.println(minCost(maxTime, edges, passingFees));
    }
    
}
