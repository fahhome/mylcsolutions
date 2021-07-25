package leetcode;

import java.util.Arrays;
import java.util.*;


// DP
// Time Complexity O(676*n)
// MLE (59/61) with 3d memo
// It is actually not a DP problem but can be solved using dp as shown below
public class NumberofGoodStrings {

    public static int solve(int index, String s, int ld, int rd, int len, int onleftpart, LinkedHashSet<Character> lhs, LinkedHashSet<Character> rhs, int[][][] memo){

        if(len == index){
            if(ld == rd && ld != 0)
                return 1;
            else 
                return 0;
        }

        if(memo[index][ld][rd] != -1)
            return memo[index][ld][rd];

        int ans1 = 0;
        int ans2 = 0;

        if(onleftpart == 1){
            // Either split at this index or dont

            //Case 1 : Split at this index
            onleftpart = 0 ; 

            // freqleft[s.charAt(index) - 97]++;
            // if(freqleft[s.charAt(index) - 97] == 1)
            //     ld++;

            if(!lhs.contains(s.charAt(index)))
                ld++;
            
            lhs.add(s.charAt(index));

            ans1 = solve(index+1, s, ld, rd, len, onleftpart, lhs, rhs,memo);

            //Case 2;
            onleftpart = 1;
            //Arrays.fill(freqright, 0); // This also work instead of the line 55
            //rhs.clear();
            ans2 =  solve(index+1, s, ld, rd, len, onleftpart, lhs, rhs, memo);

        }else{

            if(!rhs.contains(s.charAt(index)))
                rd++;
            
            rhs.add(s.charAt(index));
            
            ans2 = solve(index+1, s, ld, rd, len, onleftpart, lhs, rhs, memo);
            rhs.remove(s.charAt(index));

        }
        memo[index][ld][rd] = ans1+ans2;
        return   ans1 + ans2;

    }

    public static int numSplits(String s) {
        int len = s.length();
        // int[] freqleft = new int[26];
        // int[] freqright = new int[26];

        LinkedHashSet<Character> lefths =  new LinkedHashSet<>();
        LinkedHashSet<Character>  righths = new LinkedHashSet<>();

        int[][][] memo = new int[len][26][26];
        for(int i = 0 ; i< len ; i++)
            for(int j= 0; j < 26; j++)
                for(int k= 0 ; k< 26; k++)
                    memo[i][j][k] = -1;
        int ans = solve(0, s, 0, 0, len, 1, lefths, righths, memo);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaa";

        System.out.println(numSplits(s));
    }
}
