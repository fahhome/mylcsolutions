package leetcode;
import java.math.BigInteger;
import java.util.*;


// Reverse Pairs
// TLE with Temporary Stack Soln
public class WC19P4 {

    public static int reversePairs(int[] nums) {
        int ans = 0;
        int len  = nums.length;

        Comparator<Integer> cmp = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if (o1 > o2)
                    return 1;

                return -1;
            }

        };

        Stack<Integer> stack = new Stack<>(){
            @Override
            public Integer push(Integer item) {
                int index = Collections.binarySearch(this, item);
                if (index < 0)
                    index = ~index;
                super.add(index, item);
                return item;
            };
        };

        stack.push(nums[0]);

        for(int j = 1; j < len; j++){
            if( (long)2*nums[j] <  (long)stack.peek() ){
                int size = stack.size();
                int ctr =size -1;
                while(ctr >= 0 && ( (long)stack.get(ctr--) > (long)2*nums[j]  )){
                    ans++;
                }
            }

            // Stack<Integer> temp = new Stack<>();

            // while(!stack.isEmpty()  &&  nums[j] < stack.peek()){
            //     temp.push(stack.pop());
            // }
            // stack.push(nums[j]);

            // while(!temp.isEmpty()){
            //     stack.push(temp.pop());
            // }

            stack.push(nums[j]);

        }

        return ans; 
    }
    
    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1};
        System.out.println(reversePairs(nums));
    }
}
