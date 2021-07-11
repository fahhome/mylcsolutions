package leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

class furthestBuildingReached {
    //TLE
    /*
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        q.add(new int[] { 0, bricks, ladders });
        int ans = -1;
        int len = heights.length;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int index = front[0];
            int rembricks = front[1];
            int remladders = front[2];
            if (index > ans)
                ans = index;
            if (ans == len - 1)
                break;
            if (heights[index + 1] > heights[index]) {
                if (rembricks >= heights[index + 1] - heights[index])
                    {
                        q.add(new int[] { index + 1, rembricks - (heights[index + 1] - heights[index]), remladders });
                    }
                if (remladders > 0)
                    {
                        q.add(new int[] { index + 1, rembricks, remladders - 1 });
                    }
            } else {
                q.add(new int[] { index + 1, rembricks, remladders });
            }

        }

        return ans;
    }*/

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans  = -1;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int len = heights.length;
        int rembricks = bricks;
        int remladders = ladders;
        int i = 0;
        for(i = 0 ; i < len-1; i++){
            int diff = heights[i+1]- heights[i];
            if(diff<=0)
                continue;
            pq.add(diff);
            if(rembricks >= diff){
                rembricks -= diff;
            }else{
                if(pq.isEmpty() || remladders <=0){ // 
                    return i;
                }else{
                    int highbuilding = pq.poll();
                    remladders -= 1;
                    rembricks += highbuilding;
                    if(rembricks < diff)
                        return i;
                    else
                        rembricks -= diff;
                }
            }
        }
        ans = i;
        
        return ans;
    }


    public static void main(String[] args) {
        int[] heights = { 4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        System.out.println(furthestBuilding(heights, bricks, ladders));

    }
}
