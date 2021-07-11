package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {
    public static int jump(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int [] minjumps = new int[len];
        minjumps[0] = 0;

        if(len==1)
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(nums[0], 0));

        for (int i = 1; i < len; i++) {
            Pair front = q.peek();
            while (!q.isEmpty() && front.index + front.maxJump < i) {
                q.poll();
                if (!q.isEmpty())
                    front = q.peek();
            }
            if (!q.isEmpty()) {
                if (i == len - 1)
                    {
                        ans = minjumps[front.index] + 1 ;
                        break;
                    }
                q.add(new Pair(nums[i], i));
                minjumps[i] = minjumps[front.index] + 1;

            }
        }

        return ans ;
    }
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums));
    }
}
