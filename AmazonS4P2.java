package leetcode;

import java.util.*;

import javax.xml.catalog.CatalogFeatures.Feature;

public class AmazonS4P2 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int len = dominoes.length;

        LinkedHashMap<List<Integer>,Integer> freq = new LinkedHashMap<>();

        LinkedHashSet<List<Integer>> hset = new LinkedHashSet<>();

        for(int i = 0 ; i < len ; i++ ){

            int[] arrnow = dominoes[i];
            Arrays.sort(arrnow);
            List<Integer> listnow =  new LinkedList<>();
            listnow.add(arrnow[0]);
            listnow.add(arrnow[1]);

            if(hset.contains(listnow))
                {
                    ans = ans + freq.get(listnow);
                    freq.put(listnow, freq.get(listnow) + 1);
                }
            else{
                freq.put(listnow, 1);
                hset.add(listnow);
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
