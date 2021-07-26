package leetcode;

import java.util.Arrays;



// Try out all remaining options (that are valid)
        // for(int i = L - 1; i >= 0; i--) {
        //     if (this.nums[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
        //         if (this.recurse(mask ^ (1 << i), sidesDone)) {
        //             ans = true;
        //             break;
        //         }
        //     }
        // }

public class WC13P2 {

    static int countBits(int number) {

        return (int) (Math.log(number) / Math.log(2) + 1);
    }
    
    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int maxnum = nums[len -1];
        int maxbits = countBits(maxnum);
        int [] zeromap = new int[maxbits];
        int [] onemap = new int [maxbits];

        for(int i = 0 ; i < len ; i++){
            int num = nums[i];
            int bitpos = 0; // from right
            while(bitpos < maxbits){
                
                int bit = num & 1;
                if(bit == 0){
                    sum += onemap[bitpos];
                    zeromap[bitpos]++;
                }else{
                    sum += zeromap[bitpos];
                    onemap[bitpos]++;
                }
                num = num >> 1;
                bitpos++;
            }

        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {3,5,7};
        System.out.println(totalHammingDistance(nums));
    }

}
