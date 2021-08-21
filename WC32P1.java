package leetcode;

import java.util.Arrays;

public class WC32P1 {

    public int findUnsortedSubarray(int[] nums) {
        int ans = 0;

        int len = nums.length;

        int [] sortedarr = new int[len];
        for(int i = 0 ; i < len ; i++)
            sortedarr[i] = nums[i];

        Arrays.sort(sortedarr);


        int flag = 0;
        int i = 0;
        for(; i < len ; i++){
            if(sortedarr[i] != nums[i]){
                flag = 1;
                break;
            }
        }

        if(flag == 0)
            return 0;
        int j = len-1 ;
        for(; j > i ; j--){
            if(nums[j] != sortedarr[j])
                break;
        }

        ans = j-i+1;

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
