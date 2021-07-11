package leetcode;

import java.util.HashMap;
import java.util.Map;

// Here I have used the map itself as the dp DS ,
// so the dp[] not needed? --> Yes not needed
public class LongestArithmeticSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        
        Map<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        int[] dp = new int[len];

        for(int i = 0; i < len ; i++){
            int prevseqnumber = arr[i] - difference;
            if(map.containsKey(prevseqnumber)){
                int lenthis = 1 + map.get(prevseqnumber);
                if(lenthis > max)
                    max = lenthis;
                if(map.containsKey(arr[i])){
                    map.put(arr[i], Math.max(map.get(arr[i]), lenthis));
                    dp[i] = lenthis;
                }else{
                    map.put(arr[i], lenthis);
                    dp[i] = lenthis;
                }

            }else{
                dp[i] = 1;
                map.put(arr[i], 1);
            }
        }
        
        return max; 
    }

    public static void main(String[] args) {
        
    }
    
}
