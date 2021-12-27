package leetcode;

public class HouseRobberII {
    public static int rob(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++)
            dp[i][i] = nums[i];
        for (int i = 0; i < len; i++) {
            if (i + 1 < len)
                dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }

        int offset = 2;
        while (offset < len) {
            for (int i = 0; i < 2; i++) {
                if(i == 0 && offset == len-1){
                    dp[i][i + offset] = Math.max(nums[i + offset] + dp[i+1][i + offset - 2], dp[i][i + offset - 1]);
                }else{
                    if (i + offset < len) {
                        dp[i][i + offset] = Math.max(nums[i + offset] + dp[i][i + offset - 2], dp[i][i + offset - 1]);
                    }
                }
                
            }
            offset++;
        }

        
        return dp[0][len - 1]; 
    }

    public static void main(String[] args) {
        
    }

}
