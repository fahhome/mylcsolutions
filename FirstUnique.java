package leetcode;
import java.util.*;

public class FirstUnique {
    HashMap<Integer, Integer> freqmap;
    HashMap<Integer, Integer> fimap;
    PriorityQueue<Integer> pq;
    int nextIndex;

    public FirstUnique(int[] nums) {
        freqmap = new HashMap<>();
        fimap = new HashMap<>();

        int len = nums.length;
        pq = new PriorityQueue<>((a, b) -> {
            if (freqmap.get(a) != freqmap.get(b))
                return freqmap.get(a) - freqmap.get(b);
            else
                return fimap.get(a) - fimap.get(b);
        });
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (freqmap.containsKey(num)) {
                freqmap.put(num, freqmap.get(num) + 1);
            } else {
                fimap.put(num, i);
                freqmap.put(num, 1);
            }
            if (pq.contains(num)) {
                pq.remove(num);
                pq.add(num);
            } else {
                pq.add(num);
            }
        }

        nextIndex = len;

    }

    public int showFirstUnique() {
        if (freqmap.get(pq.peek()) != 1)
            return -1;
        return pq.peek();
    }

    public void add(int value) {

        int num = value;
        if (freqmap.containsKey(num)) {
            freqmap.put(num, freqmap.get(num) + 1);
        } else {
            fimap.put(num, nextIndex);
            freqmap.put(num, 1);
        }
        if (pq.contains(num)) {
            pq.remove(num);
            pq.add(num);
        } else {
            pq.add(num);
        }

        nextIndex++;

    }
    public static void main(String[] args) {
        
    }
}
