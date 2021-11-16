package leetcode;
import java.util.*;

public class TaskScheduler {


    public static int leastInterval(char[] tasks, int n) {


        int[] nexttimes = new int[26];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nexttimes[a] - nexttimes[b]);

        int taskslen = tasks.length;

        LinkedHashMap<Integer,Integer> hmaptasksfreq = new LinkedHashMap<>();

        for (int i = 0; i < taskslen; i++) {
            if (!pq.contains(tasks[i] - 'A'))
                pq.add(tasks[i] - 'A');
            
            if(!hmaptasksfreq.containsKey(tasks[i] - 'A')){
                hmaptasksfreq.put(tasks[i] - 'A', 1);
            }else{
                hmaptasksfreq.put(tasks[i] - 'A', hmaptasksfreq.get(tasks[i] - 'A') + 1);
            }
        }

        int timestamp = 0;

        while (taskslen > 0) {

            int pickedtask = -1;

            if (nexttimes[pq.peek()] <= timestamp) {

                pickedtask = pq.poll();
                nexttimes[pickedtask] = timestamp + n;
                taskslen--;
                hmaptasksfreq.put(pickedtask, hmaptasksfreq.get(pickedtask) - 1);
                if(hmaptasksfreq.get(pickedtask) > 0)
                    pq.add(pickedtask);
            }

            System.out.print(pickedtask + " ");

            timestamp++;

        }

        return timestamp;

    }


    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }
    
}
