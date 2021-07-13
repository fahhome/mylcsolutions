package leetcode;
import java.util.*;

//Elimination game
//
public class WC2P2 {

    
    
    public static int lastRemaining(int n) {

        int removed = 0;
        int [] dp = new int[n+1];
        int ltor  = 1;
        int lptr = 1;
        int rptr = n;
        while(removed < n-1){

            if(ltor % 2 == 1){
                int lastOther = rptr;
                boolean isOther = false;
                int i = lptr;
                while (dp[i] == 1)
                    i++;

                removed++;
                i++;
                lptr = i;
                isOther = true;
                int flag = 0;

                while (i <= rptr) {
                    if (dp[i] == 0 && isOther && flag == 0) {
                        flag = 1;
                        lptr = i;
                    }

                    if (dp[i] == 0) {
                        if (isOther) {
                            lastOther = i;
                            isOther = !isOther;
                        } else {
                            removed++;
                            isOther = !isOther;
                            dp[i] = 1;
                        }

                    }

                    i++;
                }
                rptr = lastOther;
            }else{

                boolean isOther = false;
                int i = rptr;
                int lastOther = lptr;
                while (dp[i] == 1)
                    i--;
                removed++;
                i--;
                rptr = i;
                isOther = true;
                int flag = 0;
                while (i >= lptr) {
                    if (dp[i] == 0 && isOther && flag == 0) {
                        flag = 1;
                        rptr = i;
                    }

                    if (dp[i] == 0) {
                        if (isOther) {
                            isOther = !isOther;
                            lastOther = i;
                        } else {
                            removed++;
                            isOther = !isOther;
                            dp[i] = 1;
                        }

                    }

                    i--;
                }

                lptr = lastOther;

            }
            

            ltor++;

        }

        if(dp[lptr] == 0)
            return lptr;
        
        return rptr;

    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(56));
    }


}
