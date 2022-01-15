package leetcode;
import java.util.*;

class HitCounter {

    ArrayDeque<Integer> dq;

    public HitCounter() {
        this.dq = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        dq.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        int decreaseCount = 0;
        for (Integer ts : dq) {
            if (ts + 300 > timestamp)
                break;
            decreaseCount++;
        }

        return dq.size() - decreaseCount;
    }

}
