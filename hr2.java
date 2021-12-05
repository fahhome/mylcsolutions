package leetcode;
import java.util.*;
public class hr2 {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int sum = 0;
        for(int i = 0 ; i < 5; i++)
            sum += arr.get(i);

        int minsum = sum - arr.get(4);
        int maxsum = sum - arr.get(0);

        System.out.println(minsum + " " + maxsum);
    }

    public static void main(String[] args) {
        
    }
    
}
