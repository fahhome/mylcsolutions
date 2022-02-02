package leetcode;

public class KTHMissingNumber {
    public int missingElement(int[] nums, int k) {
        int len = nums.length;

        int i = 0;

        while (i < len) {

            if (i + 1 < len && nums[i + 1] - nums[i] > 1) {

                int j = nums[i] + 1;
                while (j != nums[i + 1]) {
                    k--;
                    if (k == 0)
                        return j;
                    j++;
                }

            }

            i++;

        }

        int j = nums[i - 1] + 1;
        while (k > 0) {
            k--;
            if (k == 0)
                return j;
            j++;
        }

        return -1;

    }
}
