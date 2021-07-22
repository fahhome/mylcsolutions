package leetcode;
import java.util.*;

// Contiguous array
// 564/614 Test cases passed soln
// Correct Solution is using hashmap and detecting and observing the count  where count++ when nums[i] = 1 and count-- when nums[i] = 0
public class WC20P3 {

    public static int findMaxLength(int[] nums) {
        int ans = 0;
        int len = nums.length;

        int noOfzeros = 0;
        int noOfones = 0;

        for(int i = 0 ; i < len ; i++){
            if(nums[i] == 0)
                noOfzeros++;
            else
                noOfones++;
        }

        System.out.println(noOfones);
        System.out.println(noOfzeros);
        System.out.println(len);

        if(noOfzeros == noOfones)
            return len;

        int curcalculationzeros = 0;
        int curcalculationones = 0;

        int startptr = 0;
        int curptr = 1;

        if(nums[startptr] == 0)
            curcalculationzeros =1;
        else
            curcalculationones = 1;

        while(startptr < len && curptr < len){


            if(curcalculationones == curcalculationzeros){
                int curctgarrlen = curptr - startptr ;
                if(curctgarrlen > ans)
                    ans = curctgarrlen;
            }

            if(nums[curptr] == 0)
                curcalculationzeros++;
            else
                curcalculationones++;

            if( (curcalculationones > noOfzeros) || (curcalculationzeros > noOfones)){
                while( (startptr < len)  && (curcalculationones > noOfzeros || curcalculationzeros > noOfones)){

                    

                    if(nums[startptr] == 0)
                        curcalculationzeros--;
                    else
                        curcalculationones--;

                    startptr++;

                }
            }

            curptr++;

        }
        if (curcalculationones == curcalculationzeros) {
            int curctgarrlen = curptr - startptr;
            if (curctgarrlen > ans)
                ans = curctgarrlen;
        }


        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
        //int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxLength(nums));
        
    }
}
