package leetcode;
import java.util.*;

public class S11P1 {


    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int len = calories.length;
        int points = 0;

        int ksum = 0;
        for(int i = 0 ; i < k ; i++)
            ksum += calories[i];

        if(ksum > upper)
            points += 1;
        if(ksum < lower)
            points -= 1;
        
        for(int i = k ; i < len; i++){
            ksum -= calories[i-k];
            ksum+= calories[i];

            if (ksum > upper)
                points += 1;
            if (ksum < lower)
                points -= 1;

        }

        return points;

    }

    public static void main(String[] args) {
        
    }
    
}
