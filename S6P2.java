package leetcode;
import java.util.*;

// Important
// DFS with MEMO
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class S6P2 {

    public static int findNoOfWays(int d, int f, int target, int[] ans, int mod, int curdice, int[][] memo) {

        if (target < 0)
            return 0;

        if (target >= 0 && memo[target][curdice] != -1)
            return memo[target][curdice];

        if (curdice == d) {

            if (target == 0)
                return 1;
            else
                return 0;
        }

        int totalWaysFromHere = 0;

        for (int i = 1; i <= f; i++) {
            totalWaysFromHere = ((totalWaysFromHere % mod)
                    + (findNoOfWays(d, f, target - i, ans, mod, curdice + 1, memo) % mod)) % mod;
        }

        return memo[target][curdice] = totalWaysFromHere;

    }

    public static int numRollsToTarget(int d, int f, int target) {

        int[] ans = new int[1];
        int mod = 1000000007;

        int[][] memo = new int[1001][31];

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(memo[i], -1);
        }

        return findNoOfWays(d, f, target, ans, mod, 0, memo);

    }

    public static void main(String[] args) {
        
    }
    
}
