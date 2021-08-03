package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class WC26P1 {

    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public static int findLUSlength(String a, String b) {
        int[] ans = new int[1];
        ans[0] = -1;

        if(a.length() == b.length()){
            if(a.equals(b))
                return -1;
            
            return a.length();
        }
        else{

            return Math.max(a.length(), b.length());

        }

    }

    public static void main(String[] args) {
        
    }
}
