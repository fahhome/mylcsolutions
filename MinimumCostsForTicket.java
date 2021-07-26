package leetcode;
import java.util.*;


//https://leetcode.com/problems/minimum-cost-for-tickets/submissions/
public class MinimumCostsForTicket {

    public int solve(int[] days, int[] costs, int indexdays, int coveredtillday, int len, int[][] memo) {

        if (indexdays == (len - 1)) {

            if (coveredtillday >= days[indexdays])
                return 0;
            return Math.min(costs[0], Math.min(costs[1], costs[2]));
        }

        if (coveredtillday > 365)
            return 0;

        if (memo[indexdays][coveredtillday] != 0)
            return memo[indexdays][coveredtillday];

        if (coveredtillday >= days[indexdays]) {
            return memo[indexdays][coveredtillday] = solve(days, costs, indexdays + 1, coveredtillday, len, memo);
        } else {
            return memo[indexdays][coveredtillday] = Math.min(
                    costs[0] + solve(days, costs, indexdays + 1, days[indexdays] + 0, len, memo),
                    Math.min(costs[1] + solve(days, costs, indexdays + 1, days[indexdays] + 6, len, memo),
                            costs[2] + solve(days, costs, indexdays + 1, days[indexdays] + 29, len, memo)));
        }
    }

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[][] memo = new int[366][366];

        return solve(days, costs, 0, 0, len, memo);
    }

    public static void main(String[] args) {
        
    }
}
