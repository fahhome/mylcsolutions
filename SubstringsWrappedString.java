package leetcode;

import java.util.HashSet;
import java.util.Set;

//Not Submitted
// Lot of edge cases using this approach 
public class SubstringsWrappedString {

    public static int findSubstringInWraproundString(String p) {
        int ans = 0;
        int [] lenones = new int[26];
        int len = p.length();
        for(int i = 0; i < len ; i++ ){
            if(lenones[p.charAt(i) - 97] == 0){
                lenones[p.charAt(i) - 97] = 1;
                ans++;
            }
        }

        int [] visited = new int[26];

        Set<String> hs = new HashSet<>();
        Set<String> smallhs = new HashSet<>();

        int i = 0;

        while(i < len -1){
            int j = i+1 ;
            int substrlen = 1;
            while(j< len  && (p.charAt(j)- p.charAt(j-1) == 1 || p.charAt(j)- p.charAt(j-1) == -25  )  ){
                substrlen++;
                j++;
            }

            String candidate = p.substring(i, j);

            if(substrlen > 1){
                for (String s : hs) {
                    if (s.contains(candidate)) {
                        substrlen = 1;
                        break;
                    }
                }

                for (String s : hs) {
                    if (candidate.contains(s)) {
                        substrlen -= s.length();
                    }
                    hs.add(candidate);
                }

                ans += (substrlen * (substrlen - 1)) / 2;
            }
            
            i = j;
        }
        

        return ans ;
    }

    // Copied soln

    public int findSubstringInWraproundStringCopied(String p) {
        char[] str = p.toCharArray();
        int n = str.length;

        int[] map = new int[26];
        int len = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && ((str[i - 1] + 1 == str[i]) || (str[i - 1] == 'z' && str[i] == 'a')))
                len += 1;
            else
                len = 1;

            // we are storing the max len of string for each letter
            // and then we will count all these lenghts.
            map[str[i] - 'a'] = Math.max(map[str[i] - 'a'], len);
        }

        int answer = 0;
        for (int num : map)
            answer += num;

        return answer;
    }
    public static void main(String[] args) {
        String p = "fahmidef";

        System.out.println(findSubstringInWraproundString(p));
    }
    
}
