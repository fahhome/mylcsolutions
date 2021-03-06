package leetcode;

// COPIED
// LEARNT PREFIX SUM which is useful for calculating averages
// Instead of using this dp analogy you can use 3d dp (TRY someday)
public class LargestSumOfAverages {
   
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        for (int k = 0; k < K - 1; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = i + 1; j < N; ++j)
                    dp[i] = Math.max(dp[i], (P[j] - P[i]) / (j - i) + dp[j]);

        return dp[0];
    }

    public static void main(String[] args) {
        
    }
}
