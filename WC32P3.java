package leetcode;
import java.util.*;

public class WC32P3 {

    static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public static int minDistance(String word1, String word2) {
        int deletions = 0;


        if(word1.equals(word2))
            return 0;

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 1 ; i <= l1; i++){
            for(int j= 1; j <= l2; j++){

                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        int lcs = dp[l1][l2];


        deletions = (l1 - lcs) + (l2-lcs); 

        return deletions;
    }

    public static void main(String[] args) {
        
    }
    
}
