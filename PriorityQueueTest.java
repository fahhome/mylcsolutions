package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;


// This is the max heap wrt j field of PairTest , so the entire queue is not in descending order
public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<PairTest> pq = new PriorityQueue<>((a,b)-> b.j  - a.j);
        pq.add(new PairTest(1, 5));
        pq.add(new PairTest(3, 15));
        pq.add(new PairTest(4, 10));

        for(PairTest pt : pq){
            System.out.println(pt.i + " " + pt.j);
        }
    }
    
}


class PairTest{
    int i;
    int j;
    PairTest(int i , int j ){
        this.i = i ;
        this.j = j;
    }
}
