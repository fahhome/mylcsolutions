package leetcode;
import java.util.*;

public class WC31P1 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> hset = new HashSet<>();
        for(int i  = 0; i < candyType.length; i++)
            hset.add(candyType[i]);

        return Math.min(hset.size(),(candyType.length/2) );
    }

    public static void main(String[] args) {
        
    }
}
