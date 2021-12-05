package leetcode;

import java.util.*;

public class S8P2 {

    public int[][] kClosest(int[][] points, int k) {
        
        int totalPoints = points.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (points[a][0]*points[a][0] + points[a][1]*points[a][1]) - (points[b][0]
                * points[b][0] + points[b][1] * points[b][1]) );

        for(int i = 0 ; i < totalPoints; i++)
            pq.add(i);

        //List<List<Integer>> listans = new LinkedList<>();
        int [][] ansarr = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            ansarr[i] = points[pq.poll()];
        }

        return ansarr;

    }

    public static void main(String[] args) {
        
    }
    
}
