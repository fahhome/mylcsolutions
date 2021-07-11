package leetcode;

import java.util.PriorityQueue;

// Wrong answer
public class MaximumPerformanceOfTeam {

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int sum = 0;
        int ans = 0;
        int minEff = Integer.MAX_VALUE;
        int mod = 1000000007;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> speed[b]*efficiency[b] - speed[a]*efficiency[a] );

        for(int i = 0 ; i < n; i++)
            pq.add(i);

        while(k-- > 0){
            int engineer = pq.poll();
            int eff = efficiency[engineer];
            if(eff < minEff)
                minEff = eff;
            sum = (sum % mod + speed[engineer]%mod)%mod;
        }

        ans = ((sum%mod)*(minEff%mod))%mod;

        return ans;
    }

    public static void main(String[] args) {
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int n=6;
        int k=2;
        
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }
    
}
