package leetcode;
import java.util.*;

public class WC18P2 {   

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] ans = new String[len];
        
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        for(int i  = 0 ; i < len ; i++)
            map.put(i+1,score[i]);
        
        Map<Integer, Integer> lhp = new LinkedHashMap<>();

        map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        int i  = 1;
        for(Map.Entry<Integer,Integer> entry : lhp.entrySet()){
            int key  = entry.getKey();
            if(i == 1){
                ans[key-1] = "Gold Medal";
            }else if(i == 2){
                ans[key-1] = "Silver Medal";
            }else if(i == 3){
                ans[key-1] = "Bronze Medal";
            }else{
                ans[key-1] = String.valueOf(i);
            }
            i++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }

}
