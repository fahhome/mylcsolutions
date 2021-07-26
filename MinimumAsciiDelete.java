package leetcode;
import java.util.*;

// Bit Masking 
// O(n*2^20)
// TLE cos of line 22 to line 30
public class MinimumAsciiDelete {

    public static int solve(int state, int totalbits, int l1 , int l2, String s1,  String s2 , int[]memo){

        // Base case of both s1 and s2 empty or both are emptied stepwise
        if(state <= 0)
            return 0;

        if(memo[state] != -1)
            return memo[state];

        List<Character> s1list = new LinkedList<>();
        List<Character> s2list = new LinkedList<>();
        String s = "fahmid";
        StringBuilder ssb = new StringBuilder(s);
        StringBuilder t1 = new StringBuilder(ssb.substring(0)).reverse();
        

        for(int i = 0 ; i < l2; i++){
            
            if( ((1<<i) & state) > 0)
                s2list.add(0, s2.charAt(l2 - 1 - i ));
            
        }


        for(int i = 0; i  < l1; i++){

            if( ( (1 << (i+l2)) & state) > 0)
                s1list.add(0,s1.charAt(l1-1-i));
            
        }

        if(s1list.toString().equals(s2list.toString()))
            return 0;

        int ans = Integer.MAX_VALUE;
        for(int i = totalbits-1 ; i >= 0 ; i-- ){

            if((state & (1 << i)) > 0 ){

                int costfornextdeletion = 0;
                int lentravelled = ((totalbits - 1) - i + 1);
                if(lentravelled <= l1 )
                    {
                        costfornextdeletion = s1.charAt((totalbits - 1) - i);
                        
                    }
                else{
                        costfornextdeletion = s2.charAt(totalbits - (l1 + i + 1));
                    }
                    
                ans = Math.min(ans,  costfornextdeletion +  solve(state^(1 << i), totalbits, l1, l2, s1, s2,memo));

            }

        }

        memo[state] = ans;

        return ans;

    }

    // L --> R 1..l1 is s1 bitmask and l1+1 to (l1+l2) is s2
    public static int minimumDeleteSum(String s1, String s2) {

        int l1= s1.length();
        int l2= s2.length();

        int totalbits = l1+l2;

        int maxstate = (1 << totalbits ) - 1;
        int[] memo = new int[maxstate+2];

        Arrays.fill(memo, -1);

        int ans = solve(maxstate, totalbits, l1, l2, s1, s2,memo);

        return ans;
    }
    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";

        System.out.println(minimumDeleteSum(s1, s2));

    }
}
