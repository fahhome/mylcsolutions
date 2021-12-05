package leetcode;

public class SingleElementInASortedArray {


    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int first = 0;
        int last = len - 1;

        int ans = -1;
        while (last >= first) {

            int left = -1;
            int right = -1;

            int mid = first + (last - first) / 2;

            int curr = nums[mid];

            if (mid - 1 >= 0)
                left = nums[mid - 1];
            if (mid + 1 < len)
                right = nums[mid + 1];

            if (curr != left && curr != right) {
                return curr;
            }

            if (curr == left) {
                int leftsize = (mid - first - 1);
                int rightsize = (last - mid);

                if (leftsize % 2 == 1) {
                    last = mid - 2;
                } else {
                    first = mid + 1;
                }

            } else {
                int leftsize = (mid - first);
                int rightsize = (last - mid - 1);

                if (leftsize % 2 == 1) {
                    last = mid - 1;
                } else {
                    first = mid + 2;
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
