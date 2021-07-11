package leetcode;

import java.util.*;

https://leetcode.com/contest/biweekly-contest-56/problems/minimum-cost-to-reach-destination-in-time/

public class P3 {


    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int ans = -1;

        int[][] visited = new int[edges.length][3];
        Map<Integer, int[]> map = new HashMap<>();



        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0,});

        return ans; 
    }
    
    public static void main(String[] args) {
        
    }
}
