package leetcode;

// Max Consecutive Ones
public class W15P1 {
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int ans = 0;

        int i = 1;

        ans = nums[0] == 1 ? 1 : 0;

        int temp = nums[0] == 1 ? 1 : 0;

        for(i = 1; i < len; i++){
            if(nums[i] == 1){
                if(nums[i-1] == 1)
                    temp++;
                else
                    temp=1;

                if(temp > ans)
                    ans = temp;
            }
        }

        return ans;
        
    }

    public static void main(String[] args) {
        
    }
}
