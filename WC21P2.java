package leetcode;
import java.util.*;

// CONTIGUOUS SUBARRAY PROBLEM
// RETURN TRUE IF A SUBARRAY EXISTS WHICH SUM IS A MULTIPLE OF K
public class WC21P2 {

    public boolean checkSubarraySum(int[] nums, int k) {
        boolean ans = false;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        int len = nums.length;
        if (len < 2)
            return ans;

        int[] csarr = new int[len];
        csarr[0] = nums[0];
        set.add(csarr[0]);

        int contzero = 0;
        for (int i = 1; i < len; i++) {

            if (nums[i] != 0)
                contzero = 0;
            else
                contzero++;

            if (contzero >= 2)
                return true;
            csarr[i] = csarr[i - 1] + nums[i];

            set.add(csarr[i]);
            if (csarr[i] % k == 0)
                return true;
            int test = csarr[i] - (csarr[i] % k);

            while (test > 0) {
                if (set.contains(csarr[i] - test) && csarr[i - 1] != (csarr[i] - test))
                    return true;

                test -= k;

            }

        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
