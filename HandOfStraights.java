package leetcode;

import java.util.PriorityQueue;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {

        int len = hand.length;
        if(len%groupSize != 0)
            return false;
        
        int noGroups = len/groupSize;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i < len; i++)
            pq.add(hand[i]);
        
        for(int i = 0 ; i < noGroups; i++){
            int startingNumberOfGroup = pq.poll();
            for(int k = 1 ; k< groupSize; k++){
                if(!pq.remove(++startingNumberOfGroup))
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int [] hand = { 1, 2, 3, 6, 2, 3, 4, 7};
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));
    }
}
