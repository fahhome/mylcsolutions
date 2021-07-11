package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// BFS
public class JumpGameIII {

    public static boolean canReach(int[] arr, int start) {

        int len = arr.length;
        int [] visited = new int[len];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int frontindex = q.poll();
            int jumpvalue = arr[frontindex];
            if(jumpvalue == 0)
                return true;
            if(frontindex>=jumpvalue && visited[frontindex-jumpvalue] == 0)
                {
                    q.add(frontindex-jumpvalue);
                    visited[frontindex-jumpvalue] = 1;
                }
            if(frontindex + jumpvalue < len && visited[frontindex + jumpvalue] == 0){
                    q.add(frontindex + jumpvalue);
                    visited[frontindex + jumpvalue] = 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int [] arr = { 3, 0, 2, 1, 2};
        System.out.println(canReach(arr, 2));
    }
}
