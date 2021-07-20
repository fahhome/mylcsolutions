package leetcode;

public class WC17P2 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = 0 ;

        int prevleft = -1;
        int prevright = -1;

        int curleft = -1;
        int curright = -1;

        ans = ans + duration;
        prevleft = timeSeries[0];
        prevright = timeSeries[0] + duration -1 ;

        for(int i = 1 ; i < n; i++){
            curleft = timeSeries[i];
            curright = timeSeries[i] + duration -1;

            if(curleft > prevright)
                ans += duration ;
            else{
                ans = ans + (curright - prevright);
            }
            
            prevleft = curleft;
            prevright = curright;

        }
        return ans;
    }


    public static void main(String[] args) {
        int[] timeSeries = {1,4};
        int duration = 2;

        System.out.println(findPoisonedDuration(timeSeries, duration));

    }
}
