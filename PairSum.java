package leetcode;

import java.util.Arrays;

public class PairSum {

    public static int minPairSum(int[] nums) {
        int ans  = Integer.MIN_VALUE;
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){

            ans = Math.max(ans, nums[i] + nums[j]);

            i++;
            j--;
        }

        return ans;

    }
    public static void main(String[] args) {
        int [] nums = { 3, 5, 4, 2, 4, 6};
        System.out.println(minPairSum(nums));
    }
    
}
