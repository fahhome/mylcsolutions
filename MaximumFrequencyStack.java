package leetcode;
import java.util.*;


// https://leetcode.com/submissions/detail/597305214/

public class MaximumFrequencyStack {
    Stack<Integer> stack;
    HashMap<Integer, Integer> hmap;
    PriorityQueue<Integer> pq;

    public FreqStack() {
        this.stack = new Stack<>();
        this.hmap = new HashMap<>();
        this.pq = new PriorityQueue<>((a,b)-> b-a);
    }

    public void push(int val) {

        hmap.put(val, hmap.getOrDefault(val, 0) + 1);
        if (pq.contains(hmap.get(val) - 1))
            pq.remove(hmap.get(val) - 1);
        pq.add(hmap.get(val));
        stack.push(val);
    }

    public int pop() {
        Stack<Integer> ts = new Stack<>();
        while (hmap.get(stack.peek()) < pq.peek()) {
            ts.push(stack.pop());
        }

        int popped = stack.pop();
        hmap.put(popped, hmap.get(popped) - 1);
        pq.remove(hmap.get(popped) + 1);
        pq.add(hmap.get(popped));

        while (!ts.isEmpty()) {
            stack.push(ts.pop());
        }

        return popped;

    }
    
}
