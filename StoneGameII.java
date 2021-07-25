package leetcode;

// DP, GameTheory, MaxMin Optimization DP problem
public class StoneGameII {
    
    public static int solve(int[] piles, int len, int m, int index, int[] prefixsum) {

        if (index >= len)
            return 0;

        if (m >= (len - index)) {
            int sum = 0;
            for (int i = index; i < len; i++)
                sum += piles[i];
            return sum;
        }

        int ans = Integer.MIN_VALUE;

        int x = 0;
        int sum = 0;

        int minchoice = Integer.MAX_VALUE;
        
        for (x = 0;x < (2 * m); x++) {

            if(index + x < len)
            {
                sum += piles[index + x];

                for(int j = 0; j <= 2*m  ; j++){
                    if(index + x + j + 2 <= len){
                        minchoice = sum
                                + Math.min(solve(piles, len, Math.max(m, x), index + x + j + 2, prefixsum), minchoice);
                    }
                     
                }
                
            }
                
            ans = Math.max(ans, minchoice); 
            minchoice = Integer.MAX_VALUE;
            
        }

        return ans;

    }

    public static int stoneGameII(int[] piles) {
        int len = piles.length;
        int m = 1;
        int[] prefixsum = new int[len];
        prefixsum[0] = piles[0];
        for(int i = 1; i < len; i++)
            prefixsum[i] = piles[i] + prefixsum[i-1];
        return solve(piles, len, m, 0, prefixsum);
    }

    public static void main(String[] args) {
        int[] piles ={ 1, 2, 3, 4, 5,100};
        System.out.println(stoneGameII(piles));
    }

}
