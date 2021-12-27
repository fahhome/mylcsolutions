package leetcode;
import java.util.*;

// DP problem similar to House Robber
public class DeleteAndEarn {

    HashMap<Integer, Integer> cmap;

    public int dp(int[] nums, int idx, int len, int[] memo) {
        if (memo[idx] != -1)
            return memo[idx];
        if (idx > 10000)
            return 0;
        if (!cmap.containsKey(idx))
            return dp(nums, idx + 1, len, memo);

        return memo[idx] = Math.max(cmap.get(idx) * idx + dp(nums, idx + 2, len, memo),
                dp(nums, idx + 1, len, memo));
    }

    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] memo = new int[10005];
        Arrays.fill(memo, -1);
        cmap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            cmap.put(nums[i], cmap.getOrDefault(nums[i], 0) + 1);
        }
        return dp(nums, 0, len, memo);
    }

    
    public static void main(String[] args) {
        
    }
}
