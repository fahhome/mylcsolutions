package leetcode;
import java.util.*;


// Give the Median of sorted Window at every stage
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
                return nums[o1] - nums[o2];
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
            int num2index = window.get(k/2);
            int num1index = window.get( (k/2) -1);

            ans[ctr] = (nums[num2index] + nums[num1index])/2.00000;

        }else{
            ans[ctr] = nums[window.get(k/2)]/1.00000;
        }
        ctr++;
        int j = k;
        while(ctr < anslen){
            window.remove((Integer)(j-k));
            window.add(j);

            if (k % 2 == 0) {
                int num2index = (k / 2);
                int num1index = num2index - 1;

                ans[ctr] = (nums[window.get(num2index)] + nums[window.get(num1index)]) / 2.00000;

            } else {
                ans[ctr] = (nums[window.get(k/2)]) / 1.00000;
            }

            j++;
            ctr++;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,1,4,2};
        int k = 3;
        double[] ans = medianSlidingWindow(nums, k);
        for(int i = 0; i < ans.length; i++)
            System.out.println(ans[i] + " ");
    }
    
}
