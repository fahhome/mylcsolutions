package leetcode;

// Nice DP Problem
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int ans = 1;

        int len = nums.length;

        // 2 colums, [0] will contain considering this ith element is part of the sequence ending with +ve diff
        int [][] dp = new int[len][2];

        for(int i = 0; i < len; i++){

            int maxpos = 0;

            for(int k = 0 ; k< i; k++){

                if(nums[k] < nums[i] && dp[k][1] > maxpos){
                    maxpos = dp[k][1];
                }

            }

            dp[i][0] = 1 + maxpos;

            if(dp[i][0] > ans)
                ans = dp[i][0];

            int maxneg = 0;

            for (int k = 0; k < i; k++) {

                if (nums[k] > nums[i] && dp[k][0] > maxneg) {
                    maxneg = dp[k][0];
                }

            }

            dp[i][1] = 1 + maxneg;

            if (dp[i][1] > ans)
                ans = dp[i][1];


        }

        return ans;
    }


    public static void main(String[] args) {
        
    }
    
}
