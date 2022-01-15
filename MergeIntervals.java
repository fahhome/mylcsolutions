package leetcode;
import java.util.*;

// IMPORTANT
// Sort 2d array
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int totalIntervals = intervals.length;
        int i = 0;
        List<int[]> nonOLIntervals = new LinkedList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        while (i < totalIntervals) {
            int startNI = intervals[i][0];
            int endNI = intervals[i][1];

            int j = i + 1;
            while (j < totalIntervals && intervals[j][0] <= endNI) {
                endNI = Math.max(intervals[j][1], endNI);
                j++;
            }

            i = j;
            nonOLIntervals.add(new int[] { startNI, endNI });

        }

        int[][] ans = new int[nonOLIntervals.size()][2];

        for (int k = 0; k < nonOLIntervals.size(); k++)
            ans[k] = nonOLIntervals.get(k);

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
