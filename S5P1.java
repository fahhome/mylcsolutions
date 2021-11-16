package leetcode;

import java.util.LinkedHashMap;
import java.util.*;

public class S5P1 {


    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        int [] ans = new int[len];

        LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<>();

        for(int i = 0 ; i < len; i++){
            lhmap.put(i,arr[i]);
        }

        Map<Integer, Integer> lhp = new LinkedHashMap<>();

        lhmap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        int currank = 0;
        int prevValue = Integer.MIN_VALUE;

        for(Map.Entry<Integer,Integer> entry : lhmap.entrySet()){
            if(entry.getValue() > prevValue){
                currank++;
                prevValue = entry.getValue();
            }
            ans[entry.getKey()] = currank;
        }

        return ans;


    }


    public static void main(String[] args) {
        
    }
    
}
