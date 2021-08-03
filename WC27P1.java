package leetcode;
import java.util.*;

public class WC27P1 {

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            ans.append(new StringBuilder(words[i]).reverse());
            if(i < words.length - 1)
                ans.append(" ");
        }

        return new String(ans);

    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
