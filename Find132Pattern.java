package leetcode;

public class Find132Pattern {

    public static boolean find132pattern(int[] nums) {
        int len = nums.length;
        boolean ans = false;
        int a = 0;
        int b = 0;
        int c = 0;
        int i = 1;
        while (i < len) {
            if (nums[i] > nums[i - 1]) {
                a = nums[i - 1];
                int j = i + 1;
                while (j < len && nums[j] > nums[j - 1]) {
                    j++;
                }
                if (j < len) {
                    b = nums[j - 1];
                    c = nums[j];
                }

                if (a < b && b > c) {
                    ans = true;
                    break;
                }
                i = j - 1;
            }

            i++;

        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {3,1,4,2};
        System.out.println(find132pattern(nums));
    }
}
