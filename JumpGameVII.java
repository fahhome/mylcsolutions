package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Convert character to integer
public class JumpGameVII {

    public static boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        int len = s.length();
        q.add(0);
        int farthest = 0;
        
        while(!q.isEmpty()){
            int index  = q.remove();
            if(index == len-1)
                return true;
            int start = Math.max(index+minJump, farthest+1);  
            for(int i = start;  i<= index+maxJump && i < len ; i++){
                if(s.charAt(i) - '0' == 0)
                    {
                        q.add(i);
                        if(i > farthest)
                            farthest = i;
                    }
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
