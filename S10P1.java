package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.*;

public class S10P1 {

    // Does not work in all cases 
    public static LinkedHashMap<String,Integer> wordFreqFrompara(String para){

        String[] wordssplit = para.split(" ");

        List<Character> trailingchars = new LinkedList<>();

        trailingchars.add('.');
        trailingchars.add('?');
        trailingchars.add(';');
        trailingchars.add(',');
        trailingchars.add('!');
        trailingchars.add('\'');

        
        for(int i = 0; i < wordssplit.length;  i++){
            String word = wordssplit[i];
            if(  trailingchars.contains(word.charAt(word.length()-1)) ){
                wordssplit[i] = word.substring(0, word.length()-1);
            }
        }

        LinkedHashMap<String,Integer> freqmap = new LinkedHashMap<>();
        for(String word : wordssplit){
            if(!freqmap.containsKey(word.toLowerCase())){
                freqmap.put(word.toLowerCase(), 1);
            }else{
                freqmap.put(word.toLowerCase(), freqmap.get(word.toLowerCase()) + 1);
            }
        }
        
        return freqmap;

    }


    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> lhp = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> freqMap = wordFreqFrompara(paragraph);
        freqMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        List<String> bannedList = new LinkedList<>();
        for(String banstr : banned)
            bannedList.add(banstr);

        String ans = "";

        for(Map.Entry<String,Integer> entry : lhp.entrySet()){
            if(!bannedList.contains(entry.getKey())){
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }   

    public static void main(String[] args) {
        
    }
}
