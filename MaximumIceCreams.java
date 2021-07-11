package leetcode;

import java.util.Arrays;

// Greedy Algorithm solution 
public class MaximumIceCreams {

    public int maxIceCream(int[] costs, int coins) {

        int ans = 0;
        int len = costs.length;
        Arrays.sort(costs);

        if (costs[0] > coins)
            return ans;
        int i = 0;
        while (coins > 0 && i < len) {
            coins -= costs[i];
            i++;
            if (coins >= 0) {
                ans++;
            }
        }

        return ans;

    }
    
}
