package leetcode;
import java.util.*;

// TLE as get and put are not O(1)
public class LRUCachePQ {

    int capacity;
    int[] keyTimestamps;
    PriorityQueue<Integer> pqkey;
    LinkedHashMap<Integer, Integer> cache;
    int timestamp;

    public LRUCachePQ(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
        timestamp = 0;
        keyTimestamps = new int[10001];
        Arrays.fill(keyTimestamps, 0);
        pqkey = new PriorityQueue<>((a, b) -> keyTimestamps[a] - keyTimestamps[b]);
    }

    public int get(int key) {
        timestamp++;
        System.out.println("GET" + timestamp);
        if (cache.containsKey(key)) {
            keyTimestamps[key] = timestamp;
            pqkey.remove(key);
            pqkey.add(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        timestamp++;
        System.out.println("PUT" + timestamp);
        if (cache.containsKey(key)) {
            cache.put(key, value);
            keyTimestamps[key] = timestamp;
            pqkey.remove(key);
            pqkey.add(key);
        } else {
            if (cache.size() == capacity) {
                int evictedkey = pqkey.poll();
                keyTimestamps[evictedkey] = 0;
                cache.remove(evictedkey);
                pqkey.remove(evictedkey);
                cache.put(key, value);
                keyTimestamps[key] = timestamp;
                pqkey.add(key);
            } else {
                cache.put(key, value);
                keyTimestamps[key] = timestamp;
                pqkey.add(key);
            }
        }
    
    }


    public static void main(String[] args) {
        
    }
    
}
