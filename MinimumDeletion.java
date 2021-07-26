package leetcode;

// This problem was also marked as DP
public class MinimumDeletion {
    public int minCost(String s, int[] cost) {

        int len = s.length();
        int ans = 0;

        for (int i = 1; i < len; i++) {

            int curchar = s.charAt(i);
            if (s.charAt(i) == s.charAt(i - 1)) {

                int sum = cost[i - 1];

                int j = i;
                int max = cost[i - 1];

                while (j < len && s.charAt(j) == curchar) {
                    sum += cost[j];
                    if (cost[j] > max)
                        max = cost[j];
                    j++;
                }

                sum -= max;

                ans += sum;

                i = j - 1;

            }

        }

        return ans;

    }
}
