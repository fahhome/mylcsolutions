package leetcode;

import java.util.ArrayDeque;
import  java.util.*;
import java.util.Queue;

// TLE --> Without PQ , normal approach
// Try with PQ -->
public class MinimumCostToReachDestinationWithinMaxTime {

    static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int ans = Integer.MAX_VALUE;

        int n  = passingFees.length;

        int [][] adjmatrix = new int[n][n];

        int noedges = edges.length;

        for(int i = 0 ; i < noedges; i++){
            adjmatrix[edges[i][0]][edges[i][1]] = edges[i][2];
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1] - b[1]);

        q.add(new int[]{0,passingFees[0],0});

        while(!q.isEmpty()){
            int[] front = q.poll();
            int curvertex = front[0];
            int curcost = front[1];
            int curtime = front[2];

            if(curvertex == n-1 && curtime <= maxTime){
                if(curcost < ans)
                    {
                        ans = curcost;
                        //break;
                    }
            }else{

                for(int i = 0; i < n; i++){
                    if(i != curvertex && adjmatrix[curvertex][i] > 0){
                        q.add(new int[]{i,curcost+passingFees[i],curtime+adjmatrix[curvertex][i]});
                    }
                }
                

            }


        }

        if(ans == Integer.MAX_VALUE)
            return -1;

        return ans ;
    }


    public static void main(String[] args) {
        int maxTime = 25;
        int [][]edges = {{ 0, 1, 10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15} };
        int [] passingFees  = { 5, 1, 2, 20, 20, 3};

        System.out.println(minCost(maxTime, edges, passingFees));

    }
    
}
