package leetcode;

import java.util.*;

public class P1 {
    
    public static int countTriples(int n) {
        int ans  = 0;
        
        int[] squares = new int[n+1];
        
        for(int i = 1 ; i <=n; i++ )
            squares[i] = i*i;

        Set<Integer> doublets = new HashSet<>();
        Map<Integer,Integer> counts = new HashMap<>();

        for(int i = 1; i<= n; i++)
            for(int j = i+1; j <= n ; j++){
                doublets.add(i*i + j*j);
                counts.put(i*i + j*j, 2);
                if(i==j)
                    counts.put(i*i + j*j, 1);
            }
        
        for(int i = 1; i <=n; i++){
            if(doublets.contains(i*i))
                {
                    ans += counts.get(i*i);
                }
        }

        
        return ans;
        
    }
    public static void main(String[] args) {

        System.out.println(countTriples(25));
        
    }

}
