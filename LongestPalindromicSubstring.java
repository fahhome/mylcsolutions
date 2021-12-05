package leetcode;

import java.util.Stack;

public class LongestPalindromicSubstring {


    public static String longestPalindrome(String s) {
        String ans = Character.toString(s.charAt(0));
        int strlen = s.length();
        int currentLongest = 1 ; 

        for(int i=0 ; i < strlen -1 ; i++ ){
            int trialLength  = 2 ;
            // Try out all the trialLengths  upto the end of string from this index beginning from 2 
            while( i + trialLength <= strlen ){

                int leftptr  = i ;
                int rightptr = i+trialLength -1 ;

                if(trialLength >= currentLongest){

                    while(leftptr <= rightptr){
                        if(s.charAt(leftptr) != s.charAt(rightptr))
                            break;
                        leftptr++;
                        rightptr--;
                    }

                    if(leftptr > rightptr){
                        if(trialLength > currentLongest){
                            currentLongest = trialLength ;
                            ans = s.substring(i, i+trialLength);
                        }
                    }
                }

                trialLength++;
            }

        } 

        return ans ;
    }

    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }
    
}
