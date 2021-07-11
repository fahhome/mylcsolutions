package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Find  the h-index of a scientist
// where h-index is the maximum  number such that he has atleast h papers in which citation received is >= h 
public class HIndex {
    public int hIndex(int[] citations) {
        int ans = 0 ;
        int len = citations.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i = 0 ; i< len ; i++){
             int citation = citations[i];
             for(int j =1 ; j <= citation ; j++){
                 if(!map.containsKey(j))
                    map.put(j,1);
                 else
                    map.put(j, map.get(j) + 1);
             }
        }

        Set<Integer> keySet = map.descendingKeySet();

        for(Integer key : keySet){
            if(map.get(key) >= key ){
                ans = key ;
                break;
            }
        }

        return ans ; 
    }
    public static void main(String[] args) {
        
    }
}
