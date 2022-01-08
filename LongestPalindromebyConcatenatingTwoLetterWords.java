package leetcode;
import java.util.*;

public class LongestPalindromebyConcatenatingTwoLetterWords {
        public static int longestPalindrome(String[] words) {
        int len = words.length;

        HashMap<String, Integer> fmap = new HashMap<>();
        for (String str : words) {
            fmap.put(str, fmap.getOrDefault(str, 0) + 1);
        }

        int ans = 0;
        int flag =0;
        for (Map.Entry<String, Integer> entry : fmap.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            String rkey = new StringBuilder(key).reverse().toString();
            if ( (key.charAt(0) != key.charAt(1))  && fmap.containsKey(rkey) && fmap.get(rkey) != 0 && fmap.get(key) != 0) {
                Integer rval = fmap.get(rkey);
                int pairs = Math.min(val, rval);
                fmap.put(key, val - Math.min(val, rval));
                fmap.put(rkey, rval - Math.min(val, rval));

                ans += pairs * 2 * 2;

            }
            
            if(key.charAt(0) == key.charAt(1)){
                int pairs = val/2;
                ans += pairs*2*2;
                int rem = val % 2;
                if(rem == 1)
                    flag =1;
            }
        }
        
        if(flag == 1)
            ans += 2;
        
        

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"lc","gg","cl"};
        System.out.println(longestPalindrome(words));
    }
}
