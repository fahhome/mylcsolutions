package leetcode;

public class W16AP2 {

    public static void dfs(int[] ans , int target , int [] nums , int len, int index, int cursum){
        if(index == len && cursum == target)
            ans[0]++;
        

        if(index < len)
            dfs(ans, target, nums, len, index+1, cursum + nums[index]);
        if (index < len)
            dfs(ans, target, nums, len, index+1, cursum - nums[index]);

        
    }
    
    public static  int findTargetSumWays(int[] nums, int target) {
        int [] ans = new int[1];
        int len = nums.length;

        dfs(ans, target, nums, len, 0, 0);

        return ans[0] ; 
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3; 
        System.out.println(findTargetSumWays(nums, target));
    }

}
