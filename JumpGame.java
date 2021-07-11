package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    public static boolean canJump(int[] nums) {

        Queue<Pair> q = new LinkedList<>();
        int len = nums.length;
        if(len == 1)
            return true;
        q.add(new Pair(nums[0], 0));

        for(int i = 1; i< len ; i++){
            Pair front = q.peek();
            while(!q.isEmpty()  && front.index + front.maxJump < i )
                {
                    q.poll();
                    if(!q.isEmpty())
                        front = q.peek();
                }
            if(!q.isEmpty())
                {
                    if (i == len - 1)
                        return true;
                    q.add(new Pair(nums[i], i));
                                        
                }
        }

        return false;

    }
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}

class Pair{
    public int maxJump;
    public int index;

    public Pair(int maxJump,int index){
        this.maxJump = maxJump;
        this.index = index ;
    }
}
