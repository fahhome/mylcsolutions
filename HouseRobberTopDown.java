package leetcode;
import java.util.*;

public class HouseRobberTopDown {

    public int dp(int[] nums, int index, int[] memo) {

        if (memo[index] != -1)
            return memo[index];
        if (index >= nums.length)
            return 0;
        if (index == nums.length - 1)
            return nums[index];

        return memo[index] = Math.max(nums[index] + dp(nums, index + 2, memo), dp(nums, index + 1, memo));

    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[] memo = new int[len + 2];
        Arrays.fill(memo, -1);
        return dp(nums, 0, memo);
    }

    public static void main(String[] args) {
        
    }
}
