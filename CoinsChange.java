package leetcode;
import java.util.*;
public class CoinsChange {
    public static void reverse(int[] validData) {
        for (int i = 0; i < validData.length; i++) {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
    }

    public static int dp(int[] coins, int remamt, int idx, int len, int[][] memo) {

        
        if (remamt == 0)
            return 0;
        if (idx >= len)
            return 100000;
        if (coins[idx] > remamt)
            return 100000;
        
        if (memo[idx][remamt] != -1)
            return memo[idx][remamt];

        int ans = 100000;

        int div = remamt / coins[idx];

        for (int i = 0; i <= div; i++) {        
            ans = Math.min(i + dp(coins, remamt - (coins[idx] * i), idx + 1, len, memo), ans );      
        }

        return memo[idx][remamt]=ans;

    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        // Arrays.sort(coins,Collections.reverseOrder());
        //reverse(coins);
        Arrays.sort(coins);
        int[][] memo = new int[len][10001];
        for(int i = 0; i < len ;i++)
            Arrays.fill(memo[i],-1);
        int ans = dp(coins, amount, 0, len, memo);
        if (ans < 0 || ans >= 100000)
            return -1;
        return ans;
    }
    public static void main(String[] args) {
        int[] coins ={5,2,1};
        System.out.println(coinChange(coins, 11));
    }
}
