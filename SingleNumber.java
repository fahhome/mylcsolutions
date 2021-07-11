package leetcode;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        int len = nums.length;


        for(int i = 1; i < len; i++)
            ans = ans^nums[i];

        return ans ;
    }
    
    public static void main(String[] args) {
        int [] nums = { 1};
        System.out.println(singleNumber(nums));
    }


}
