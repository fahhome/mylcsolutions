package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// This also TLE
public class JumpGameVIIBacktracking {

    public static boolean canReachdfs(String s, int minJump, int maxJump, int index , Map<Integer, Boolean> memo) {
        
        if(memo.containsKey(index))
            return memo.get(index);

        if(index == s.length() -1)
            return true;

        boolean toreturn = false;

        for(int i = minJump+index ; i <= maxJump + index && i < s.length(); i++){
           
            

            if(s.charAt(i) - '0' == 0){
                boolean fromhere = canReachdfs(s, minJump, maxJump, i, memo);
                toreturn = toreturn || fromhere;
            }

            memo.put(index, toreturn);

        }

        return toreturn;
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        Map<Integer,Boolean> hmap = new HashMap<>();
        return canReachdfs(s, minJump, maxJump, 0, hmap);

    }

    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        System.out.println(canReach(s, minJump, maxJump));
    }
    
}
