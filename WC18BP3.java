package leetcode;

public class WC18BP3 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        int[] ans = new int[len];

        for(int i = 0; i< len ; i++){

            int num = nums[i];

            int nextpos = (i+1)%len;

            int ctr = 0;
            int flag = -1;
            while(ctr <= len){

                if(nums[nextpos] > num){
                    flag = nums[nextpos];
                    break;
                }
                nextpos = (nextpos + 1) % len;
                ctr++;
            }

            ans[i] = flag;

        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
    
}
