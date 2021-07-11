package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProcessTasksUsingServer {
    public int[] assignTasks(int[] servers, int[] tasks) {
        if (tasks == null || tasks.length == 0 || servers == null || servers.length == 0)
            return new int[] {};
        int[] arr = new int[tasks.length];
        int[] endTime = new int[servers.length];
        PriorityQueue<Integer> readyQueue = new PriorityQueue<>((a, b) -> {
            if (servers[a] != servers[b])
                return servers[a] - servers[b];
            else
                return a - b;
        });
        PriorityQueue<Integer> runningQueue = new PriorityQueue<>((a, b) -> {
            return endTime[a] - endTime[b];// sort by task end time
        });
        // initialize, add all server to ready queue
        for (int i = 0; i < servers.length; i++) {
            readyQueue.add(i);
        }
        int t = 0;// global time
        int p = 0;// pointer to start of tasks
        while (p < tasks.length) {
            // Step1 : running state to ready state
            while (!runningQueue.isEmpty() && endTime[runningQueue.peek()] <= t) {
                readyQueue.add(runningQueue.poll());
            }
            // if no available server, skip time to next end time
            if (readyQueue.isEmpty()) {
                t = endTime[runningQueue.peek()];
                continue;
            }
            // Step2 : ready state to running state
            while (p < tasks.length && p <= t && !readyQueue.isEmpty()) {
                int index = readyQueue.poll();// remove from ready queue
                endTime[index] = t + tasks[p];
                runningQueue.add(index);// add to running queue
                arr[p] = index;
                p++;
            }
            // Step3 : increase global time
            t++;
        }
        return arr;
    }
    public static void main(String[] args) {
        
    }
}