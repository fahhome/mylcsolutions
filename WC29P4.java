package leetcode;
import java.util.*;

// Integer to Character 
// Check if y is power of x

// Minimally change n from midpoint

public class WC29P4 {

    // x = 10 , y = 1000
    static boolean isPower(int x, int y) {
        // logarithm function to
        // calculate value
        int res1 = (int) Math.log(y) / (int) Math.log(x);

        // Note : this is double
        double res2 = Math.log(y) / Math.log(x);

        // compare to the result1 or
        // result2 both are equal
        return (res1 == res2);
    }

    public static String nearestPalindromic(String n) {
        int len = n.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < len; i++)
        {
            ans.append(n.charAt(i));
        }

        if(len == 1){
            ans.setCharAt(0, (char)( (ans.charAt(0) - '0' - 1) + '0'));
            return new String(ans);
        }

        return new String();
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("7"));
    }
}
