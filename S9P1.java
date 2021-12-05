package leetcode;
import java.util.*;

public class S9P1 {

    public int countCharacters(String[] words, String chars) {
        int sum = 0;


        LinkedHashMap<Character,Integer> map1 = new LinkedHashMap<>();

        for(int i =0; i < chars.length(); i++){
            Character curchar = chars.charAt(i);
            if(!map1.containsKey(curchar)){
                map1.put(curchar, 1);
            }else{
                map1.put(curchar, map1.get(curchar) + 1);
            }
        }

        for(String word : words){
            LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();

            for (int i = 0; i < word.length(); i++) {
                Character curchar = word.charAt(i);
                if (!map2.containsKey(curchar)) {
                    map2.put(curchar, 1);
                } else {
                    map2.put(curchar, map2.get(curchar) + 1);
                }
            }

            int flag = 0;
            for(Map.Entry<Character, Integer> entry : map2.entrySet()){
                if(!map1.containsKey(entry.getKey()) || map1.get(entry.getKey()) < entry.getValue() ){
                    flag =1;
                    break;
                }
            }

            if(flag == 0)
                sum += word.length();

        }

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
