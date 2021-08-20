package leetcode;
import java.util.*;

// Priority Queue
public class WC253P2 {

    public int minStoneSum(int[] piles, int k) {
        int ans = 0;
        int len = piles.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (int)Math.floor(piles[b]/2) - (int)Math.floor(piles[a] / 2) );

        for(int i = 0 ; i < len ; i++){
            pq.add(i);
            ans += piles[i];
        }

        for(int i = 0 ; i < k ; i++){

            int pilehighest = pq.poll(); 

            ans = ans - (int)Math.floor(piles[pilehighest]/2);

            piles[pilehighest] = piles[pilehighest] - (int) Math.floor(piles[pilehighest] / 2);

            pq.add(pilehighest); // Removing and adding the index again is important, the heap will not auto-update on change of piles[pilehighest]

        }

        return ans;
    }

    public static void main(String[] args) {
        
    }


}
