package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {

    private Queue<Integer> pq ;

    public SeatManager(int n) {

        pq = new PriorityQueue<>(n);
        for(int i = 1 ; i <= n ; i++)
            pq.add(i);
    }

    public int reserve() {
        if(pq.isEmpty())
            return 0;
        else
            return pq.remove();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }

    public static void main(String[] args) {
        
    }
}
