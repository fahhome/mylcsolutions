package leetcode;
import java.util.*;

public class WC2P1 {

    public char findTheDifference(String s, String t) {
        char ans = ',';

        Map <Character,Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int l1 = s.length();
        int l2=  t.length();


        for(int i = 0; i < l1; i++){
            if(map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }else{
                map1.put(s.charAt(i),1);
            }
        }

        for (int i = 0; i < l2; i++) {
            if (map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            } else {
                map2.put(t.charAt(i), 1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map1.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();

            if(!map2.containsKey(key) || ((map2.containsKey(key)) && map2.get(key) != val))
                return key;
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (!map1.containsKey(key) || ((map1.containsKey(key)) && map1.get(key) != val))
                return key;
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
    
}
