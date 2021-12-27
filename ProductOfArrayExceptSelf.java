package leetcode;

public class ProductOfArrayExceptSelf {
    // Without Use of Division Operation as there can be 0's in the array
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        int[] fromhere = new int[len];
        int[] tillhere = new int[len];

        fromhere[len - 1] = nums[len - 1];
        tillhere[0] = nums[0];

        for (int i = 1; i < len; i++)
            tillhere[i] = tillhere[i - 1] * nums[i];
        for (int i = len - 2; i >= 0; i--)
            fromhere[i] = fromhere[i + 1] * nums[i];

        for (int i = 1; i < len - 1; i++) {
            ans[i] = tillhere[i - 1] * fromhere[i + 1];
        }

        ans[0] = fromhere[1];
        ans[len - 1] = tillhere[len - 2];

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
