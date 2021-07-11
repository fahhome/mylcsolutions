package leetcode;

public class HouseRobber {

    public static int rob(int[] nums) {
        int ans = 0;
        int len = nums.length;

        int [][] dp = new int[len][len];

        for(int i = 0 ; i < len ; i++)
            dp[i][i] = nums[i];
        for(int i = 0; i < len ; i++){
            if(i+1 < len)
                dp[i][i+1] = Math.max(nums[i], nums[i+1]);
        }

        int offset = 2 ;
        while(offset < len){
            for(int i = 0 ; i < 1 ; i++){
                if(i + offset < len){
                    dp[i][i+offset] = Math.max(nums[i+offset] + dp[i][i+offset-2], dp[i][i+offset-1]);
                }
            }
            offset++;
        }
            
        // int max = -1;
        // for(int i = 0 ; i < len ; i++){
        //     if(dp[i][len-1] > max)
        //         max = dp[i][len-1];
        // }
        return dp[0][len-1] ; // Note here that the other rows in the dp table is not used , only the first row is used , it encapsulates the combinations
    }

    public static void main(String[] args) {
        int [] arr = { 2, 7, 9, 3, 1};
        System.out.println(rob(arr));
    }
}
