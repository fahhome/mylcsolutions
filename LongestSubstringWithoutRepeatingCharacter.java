package leetcode;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 1; 

        if(len == 0)
            return 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.addLast(s.charAt(0));
        for(int i = 1; i < len; i++){
            while(deque.contains((s.charAt(i))))
                deque.removeFirst();
            deque.addLast(s.charAt(i));

            if(deque.size() > ans)
                ans = deque.size();
        }

        return ans;

    }


    public static void main(String[] args) {
        
    }


}
