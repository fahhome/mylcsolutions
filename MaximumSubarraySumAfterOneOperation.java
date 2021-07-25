package leetcode;
import java.util.*;

public class MaximumSubarraySumAfterOneOperation {
    public int solve(int index, int cursum, int[] ans, int len, boolean operationUsed, int[] nums, int[][] memo) {
        if (index >= len)
            return Math.max(cursum, ans[0]);

        if (memo[index][operationUsed == true ? 1 : 0] != Integer.MIN_VALUE)
            return memo[index][operationUsed == true ? 1 : 0];

        if (cursum > ans[0]) {
            ans[0] = cursum;
            // return cursum;
        }

        if (cursum < 0)
            cursum = 0;

        if (operationUsed == true)
            return solve(index + 1, cursum + nums[index], ans, len, operationUsed, nums, memo);

        int ansfromthisindex = Math.max(
                solve(index + 1, cursum + (nums[index] * nums[index]), ans, len, true, nums, memo),
                solve(index + 1, cursum + nums[index], ans, len, false, nums, memo));

        int secparameter = operationUsed == true ? 1 : 0;
        memo[index][secparameter] = ansfromthisindex;
        return memo[index][secparameter];
    }

    public int maxSumAfterOperation(int[] nums) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        int len = nums.length;
        int[][] memo = new int[len][2];

        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        int test = solve(0, 0, ans, len, false, nums, memo);

        return test;
    }
}
