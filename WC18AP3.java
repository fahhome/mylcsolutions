package leetcode;

import java.util.PriorityQueue;

public class WC18AP3 {

    
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int ans = w;

        // This Max heap will contain projects which have capital[i] <= currentavailablecapital
        PriorityQueue<Integer> pickableprojects = new PriorityQueue<>((a,b)-> profits[b]- profits[a]);

        PriorityQueue<Integer> projects = new PriorityQueue<>((a,b) -> capital[a] - capital[b]);

        int totalProjects = profits.length;

        for(int i = 0 ; i < totalProjects; i++){

            projects.add(i);

        }

        int availableCapital  = w ;

        for(int i = 0 ; i< k; i++){

            while(null != projects.peek()  && capital[projects.peek()] <= availableCapital){
                pickableprojects.add(projects.poll());
            }

            int profitInThisRound = 0;

            if(null != pickableprojects.peek()){
                profitInThisRound = profits[pickableprojects.poll()];
            }

            ans += profitInThisRound;

            availableCapital += profitInThisRound;

        }

        return ans;
    }

    public static void main(String[] args) {
        int k = 2;
        int w= 0;
        int[] profits =  {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
