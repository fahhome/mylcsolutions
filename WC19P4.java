package leetcode;
import java.math.BigInteger;
import java.util.*;


// Reverse Pairs
// TLE with Temporary Stack Soln
public class WC19P4 {

    public static int reversePairs(int[] nums) {
        int ans = 0;
        int len  = nums.length;
        Stack<Integer> stack = new Stack<>();

        stack.push(nums[0]);

        for(int j = 1; j < len; j++){
            if( (long)2*nums[j] <  (long)stack.peek() ){
                int size = stack.size();
                int ctr =size -1;
                while(ctr >= 0 && ( (long)stack.get(ctr--) > (long)2*nums[j]  )){
                    ans++;
                }
            }

            Stack<Integer> temp = new Stack<>();

            while(!stack.isEmpty()  &&  nums[j] < stack.peek()){
                temp.push(stack.pop());
            }
            stack.push(nums[j]);

            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }

        }

        return ans; 
    }
    
    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1};
        System.out.println(reversePairs(nums));
    }
}
