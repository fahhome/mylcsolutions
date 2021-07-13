package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


// Here it is given that no number is duplicate so you can use indexMap
public class TwoSum {

    public static int lcm(int a, int b) {
        int max, step, lcm = 0;
        if (a > b) {
            max = step = a;
        } else {
            max = step = b;
        }

        while (a != 0) {
            if (max % a == 0 && max % b == 0) {
                lcm = max;
                break;
            }
            max += step;
        }
        return lcm;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> indexMap = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            
            indexMap.put(nums[i], i);
            
        }

        for(int i =0 ; i < nums.length ; i++){
            if(indexMap.containsKey(target-nums[i])){
                if(i != indexMap.get(target-nums[i])){
                    ans[0] = i;
                    ans[1] = indexMap.get(target-nums[i]);
                    break;
                }
                
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int []ans = twoSum(nums, target);
        System.err.println(ans[0] + " , " + ans[1] );
    }
}
