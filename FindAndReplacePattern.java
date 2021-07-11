package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Program to check if the pattern letters can be replaced to obtain the word
// CONSTRAINT --> one to one relationship between the patterchar and its replacement character
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        int len = pattern.length();

        for (String word : words) {
            Map<Character, Character> map = new LinkedHashMap<>();
            Map<Character,Character> reversemap = new LinkedHashMap<>();
            int i = 0;
            while (i < len) {
                Character patternChar = pattern.charAt(i);
                Character wordChar = word.charAt(i);
                if (map.containsKey(patternChar) && !map.get(patternChar).equals(wordChar))
                    break;
                if (reversemap.containsKey(wordChar) && !reversemap.get(wordChar).equals(patternChar))
                    break;
                if (!map.containsKey(patternChar))
                    {
                        map.put(patternChar, wordChar);
                        reversemap.put(wordChar, patternChar);
                    }
                i++;
            }
            if (i == len)
                ans.add(word);
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
