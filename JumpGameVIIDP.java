package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// boolean array is initialized with false
// Accepted
public class JumpGameVIIDP {
    public static boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        for(int i = 1; i < len ; i++){
            // If we go back and see if any of the previous place from where it can from is true APPROACH then it is O(n^2)
            while(!q.isEmpty() && q.peek() < i-maxJump)
                q.poll();
            if(s.charAt(i) == '0' &&  !q.isEmpty() && q.peek() >= i-maxJump && q.peek() + minJump <= i)
            {
                q.add(i);
                if(i == len-1)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        System.out.println(canReach(s, minJump, maxJump));
    }
}
