package leetcode;
import java.util.*;

public class Find132Pattern {

    // Note here we are maintening descending stack(0 to size() -1 ) annd not ascending
    // We are discarding the top of the stack with confidence after comparing with the global minimum.
    // If it is less than the global minimum at that loop , it cannot be the third element in 132 pattern in the next loops
     

    public static boolean find132pattern(int[] nums) {
        boolean ans = false;
        int len = nums.length;
        if (len < 3)
            return false;

        int[] lowestleft = new int[len];
        Stack<Integer> stack = new Stack<>();

        lowestleft[0] = nums[0];

        for (int i = 1; i < len; i++) {
            lowestleft[i] = Math.min(lowestleft[i - 1], nums[i]);
        }

        // stack.push(nums[len-1]);
        for (int i = len - 1; i >= 0; i--) {
            // consider this ith element to be the middle element
            // the greater elements on the right need not be considered
            if (nums[i] > lowestleft[i]) {
                while (!stack.isEmpty() && stack.peek() <= lowestleft[i])
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;

                stack.push(nums[i]);
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {3,1,4,2};
        System.out.println(find132pattern(nums));
    }
}
