package leetcode;
import java.util.*;

// IMPORTANT
// String in Java is sorted by creating a charArray, sorting the char array and then creating a new string out of it.
public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> ans = new LinkedList<>();
        HashMap<String, LinkedList<String>> hmap = new HashMap<>();
        for (String str : strs) {

            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String sortedstr = new String(charArray);

            if (hmap.containsKey(sortedstr)) {
                LinkedList<String> existingrow = hmap.get(sortedstr);
                existingrow.add(str);
            } else {
                LinkedList<String> newrow = new LinkedList<>();
                newrow.add(str);
                hmap.put(sortedstr, newrow);
            }

        }
        ans = new LinkedList<>(hmap.values());
        return ans;
    }

    public static void main(String[] args) {
        
    }

}
