package leetcode;
import java.util.*;

public class MSASum2 {

    public static int solve(int)
    

    public static int maxSumAfterOperation(int[] nums) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        int len = nums.length;
        int[][] memo = new int[len][2];

        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        int test = solve(0, 0, ans, len, false, nums, memo);

        return test;
    }
    public static void main(String[] args) {
        
    }
}
