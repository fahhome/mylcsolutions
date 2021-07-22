package leetcode;
import java.util.*;

public class WC20P1 {

    public boolean detectCapitalUse(String word) {
        boolean ans = false;
        int len = word.length();

        boolean allCaps = true;
        boolean allSmalls = true;
        boolean firstCapAndThenSmall = true;

        for(int i = 0; i < len ; i++){
            if(word.charAt(i)- 97 < 0){
                allSmalls = false;
                if(i != 0)
                    firstCapAndThenSmall = false;
            }else{
                allCaps = false;
            }
        }

        if(allCaps || allSmalls || firstCapAndThenSmall)
            ans = true;


        return ans;
    }
    public static void main(String[] args) {
        
    }
}
