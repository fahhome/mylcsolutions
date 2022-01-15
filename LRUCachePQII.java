package leetcode;

public class LRUCachePQII {
    int capacity;
    int ts;
    PriorityQueue<Integer> keypq;
    HashMap<Integer, Integer> tsmap;
    HashMap<Integer, Integer> kvmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keypq = new PriorityQueue<>((a,b)->{
            return tsmap.get(a) - tsmap.get(b);
        });
        tsmap = new HashMap<>();
        kvmap = new HashMap<>();
        this.ts = 0;
    }

    public int get(int key) {
        ts++;
        if (keypq.contains(key)) {

            keypq.remove(key);
            tsmap.put(key, ts);
            keypq.add(key);
            return kvmap.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        ts++;
        if (keypq.size() == capacity) {
            keypq.poll();
        } else {
            capacity++;
        }

        tsmap.put(key, ts);
        kvmap.put(key, value);
        keypq.add(key);

    }
}
