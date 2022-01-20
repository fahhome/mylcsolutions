package leetcode;
import java.util.*;

public class IsoMorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();
        int i = 0;

        while (i < slen) {

            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if (map.containsKey(sch)) {
                if (tch != map.get(sch))
                    return false;
            } else {

                if (mapped.contains(tch))
                    return false;
                map.put(sch, tch);
                mapped.add(tch);
            }
            i++;
        }

        return true;

    }
}
