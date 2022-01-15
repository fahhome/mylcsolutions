package leetcode;
import java.util.*;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        // int n = candyType.length;
        // int[][] memo = new int[n+2][n/2+2];
        // LinkedList<Integer> candiesTaken = new LinkedList<>();
        // return dp(0,n/2,candyType,memo,n,candiesTaken);
        HashSet<Integer> hset = new HashSet<>();
        for (int num : candyType) {
            hset.add(num);
        }
        int n = candyType.length;

        return Math.min(hset.size(), n / 2);
    }
}
