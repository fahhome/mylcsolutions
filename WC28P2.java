package leetcode;
import java.util.*;

public class WC28P2 {

    public String optimalDivision(int[] nums) {
        StringBuilder ans = new StringBuilder();
        int len = nums.length;
        if(nums.length == 1)
            {
                ans.append(String.valueOf(nums[0]));
                return new String(ans);
            }
        
        else{

            ans.append(String.valueOf(nums[0]));
            if(len > 2)
                ans.append("/(");
            else
                ans.append("/");
            for(int i = 1; i < nums.length ; i++){
                ans.append(String.valueOf(nums[i]));
                if(i != nums.length -1)
                    ans.append("/");
            }
            if(len>2)
                ans.append(")");

            return new String(ans);
        }


    }

    public static void main(String[] args) {
        
    }
}
