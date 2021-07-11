package leetcode;

public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        int len = nums.length;

        for (int i = 1; i < len; i++)
            ans = ans ^ nums[i];

        return (ans >> 1) | 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
    }
    
}
