package leetcode;
import java.util.*;

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/submissions/
public class LengthOfLongestSubstringTwoDistinctCharacters {


    public int lengthOfLongestSubstringTwoDistinct(String s) {

        HashMap<Character, Integer> hmap = new HashMap<>();
        int len = s.length();
        int ans = 1;
        hmap.put(s.charAt(0), 1);
        ArrayDeque<Character> dq = new ArrayDeque<>();
        dq.addLast(s.charAt(0));
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);

            // If this character ch is not present in the map containing distinct characters
            // and this character ch needs to be accommodated in it, then one of the distinct
            // characters already present in the map needs to make way. 
            if (!hmap.containsKey(ch) && hmap.size() == 2) {

                while (hmap.size() == 2) {
                    char popped = dq.removeFirst();
                    hmap.put(popped, hmap.get(popped) - 1);
                    if (hmap.get(popped) == 0)
                        hmap.remove(popped);
                }

                dq.addLast(ch);
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
                if (dq.size() > ans)
                    ans = dq.size();

            } else {
                dq.addLast(ch);
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
                if (dq.size() > ans)
                    ans = dq.size();
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        
    }


}
