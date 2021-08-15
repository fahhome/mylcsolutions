package leetcode;
import java.util.*;

// important
// Number of Contiguous Subarrays having sum K
// 3 ways ans incremented 1. Either number = k   2. prefixsum[i] = k  3. subtracting sum other subarray before it 
public class WC30P3 {

    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;

        int[] prefixsum = new int[len];
        prefixsum[0] = nums[0];
        Map<Integer,Integer> hmap = new HashMap<>();
        hmap.put(prefixsum[0], 1);

        if(nums[0] == k)
            ans++;

        for(int i= 1 ; i < len; i++)
            {
                if(nums[i] == k)
                    ans++;
                prefixsum[i] = prefixsum[i-1] + nums[i];
                if(prefixsum[i] == k)
                    ans++;
                int needed = prefixsum[i] - k;
                if(hmap.containsKey(needed)){
                    ans += hmap.get(needed);
                    if(prefixsum[i-1] == needed) // becoz here it will be the number itself which we have already accounted for
                        ans--;
                }
                if(!hmap.containsKey(prefixsum[i])){
                    hmap.put(prefixsum[i], 1);
                }else{
                    hmap.put(prefixsum[i], hmap.get(prefixsum[i]) + 1 );
                }
            }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,2,0,0,2};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }


}
