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

    // Simpler
    // public int rob(int[] nums) {

    //     int N = nums.length;

    //     // Special handling for empty array case.
    //     if (N == 0) {
    //         return 0;
    //     }

    //     int[] maxRobbedAmount = new int[nums.length + 1];

    //     // Base case initializations.
    //     maxRobbedAmount[N] = 0;
    //     maxRobbedAmount[N - 1] = nums[N - 1];

    //     // DP table calculations.
    //     for (int i = N - 2; i >= 0; --i) {

    //         // Same as the recursive solution.
    //         maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
    //     }

    //     return maxRobbedAmount[0];
    // }

    public static void main(String[] args) {
        int [] arr = { 2, 7, 9, 3, 1};
        System.out.println(rob(arr));
    }
}
