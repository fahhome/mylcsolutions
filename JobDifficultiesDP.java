package leetcode;

import java.util.Arrays;

public class JobDifficultiesDP {

    public static int dp(int[] jobDifficulty, int d, int drem,
            int len, int start, int[][] maxbunch, int[][] memo) {


        if(memo[start][drem] > -1)
            return memo[start][drem];
         
        if (drem == 1)
            return memo[start][drem]=maxbunch[start][len - 1];

        if (start >= len)
            return 500000;

        int ansfh = 500000;

        for (int i = start + 1; i < len; i++) {
            ansfh = Math.min(ansfh, maxbunch[start][i - 1] + dp(jobDifficulty, d, drem - 1, len, i, maxbunch,memo));
        }

        return memo[start][drem] =ansfh;

    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;

        if (d > len)
            return -1;

        int[][] maxbunch = new int[len][len];

        maxbunch[0][0] = jobDifficulty[0];
        maxbunch[len - 1][len - 1] = jobDifficulty[len - 1];

        for (int i = 1; i < len; i++)
            maxbunch[i][i] = jobDifficulty[i];

        for (int i = 0; i < len; i++) {
            int maxnow = jobDifficulty[i];
            for (int j = i + 1; j < len; j++) {
                if (jobDifficulty[j] > maxnow)
                    maxnow = jobDifficulty[j];
                maxbunch[i][j] = maxnow;
            }
        }
        int[][] memo = new int[len+1][d+1];
        for(int i = 0; i < memo.length;i++)
            Arrays.fill(memo[i], -1);
        return dp(jobDifficulty, d, d, len, 0, maxbunch,memo);

    }
    
    public static void main(String[] args) {
        int[] jobDifficulty = {6,6,6};
        int d = 3;
        System.out.println(minDifficulty(jobDifficulty, d));
    }
}
