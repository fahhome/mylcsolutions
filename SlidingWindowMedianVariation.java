package leetcode;
import java.util.*;


// Give the Median of sorted Window at every stage
// Problem is Double Overflow over large additions
// NOTE: the compare function here the nums[o1] - nums[o2] technique only works when all numbers are non-negative
public class SlidingWindowMedianVariation {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int anslen = 0;
        if(len >= k){
            anslen = 1 + (len-k);
        }else{
            double[] ans = new double[0];
            return ans;
        }

        double[] ans = new double[anslen];

        Comparator<Integer> cmp =  new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if(nums[o1] > nums[o2])
                    return 1;
                
                return -1;
            }

        };
        LinkedList<Integer> window = new LinkedList<>(){
            @Override
            public boolean add(Integer e) {
                super.add(e);
                Collections.sort(this,cmp);
                return true;
            };
        };
        

        for(int i = 0 ; i < k; i++)
            window.add(i);

        int ctr = 0;

        //int median = -1;

        if(k % 2 == 0){
            int num2index = (k/2);
            int num1index = num2index - 1;

            //System.out.println(nums[num2index]);
            //System.out.println(nums[num1index]);

            ans[ctr] = (nums[window.get(num2index)]*1.00000 + nums[window.get(num1index)]*1.00000)/2.00000; // Integer overflow happens so do additions after converting to double double has precision 2^64

        }else{
            ans[ctr] = (nums[window.get(k/2)]*1.00000)/1.00000;
        }
        ctr++;
        int j = k;
        while(ctr < anslen){
            window.remove((Integer)(j-k));
            window.add(j);

            if (k % 2 == 0) {
                int num2index = (k / 2);
                int num1index = num2index - 1;

                ans[ctr] = (nums[window.get(num2index)]*1.00000 + nums[window.get(num1index)]*1.00000) / 2.00000;

            } else {
                ans[ctr] = (nums[window.get(k/2)]*1.00000) / 1.00000;
            }

            j++;
            ctr++;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 6;
        double[] ans = medianSlidingWindow(nums, k);
        for(int i = 0; i < ans.length; i++)
            System.out.println(ans[i] + " ");
    }
    
}
