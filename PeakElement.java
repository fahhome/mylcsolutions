package leetcode;

public class PeakElement {
    public int fpk(int[] nums, int first, int last) {

        if (first > last)
            return -1;

        int idx = -1;
        int mid = first + (last - first) / 2;
        if (mid == 0 && mid + 1 < nums.length && nums[mid] > nums[mid + 1])
            return mid;
        if (mid == nums.length - 1 && mid - 1 >= 0 && nums[mid] > nums[mid - 1])
            return mid;

        if ((mid - 1 >= 0 && nums[mid] > nums[mid - 1]) && (mid + 1 < nums.length && nums[mid] > nums[mid + 1]))
            return mid;

        int idxleft = fpk(nums, first, mid - 1);
        int idxright = fpk(nums, mid + 1, last);

        if (idxleft < 0 && idxright < 0)
            return -1;

        return Math.max(idxleft, idxright);

    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        return fpk(nums, 0, len - 1);
    }
}
