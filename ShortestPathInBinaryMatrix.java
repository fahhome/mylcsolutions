package leetcode;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    int n;

    public boolean isSafe(int row, int col) {

        if (row < 0 || row >= n || col < 0 || col >= n)
            return false;

        return true;

    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        this.n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();

        if (grid[0][0] == 0)
            q.add(new int[] { 0, 0, 1 });
        int[][] visited = new int[n][n];
        visited[0][0] = 1;

        int[] dirr = { -1, 0, 1, 0, -1, 1, 1, -1 };
        int[] dirc = { 0, 1, 0, -1, 1, 1, -1, -1 };

        while (!q.isEmpty()) {

            int[] front = q.poll();
            int curr = front[0];
            int curc = front[1];
            int curmoves = front[2];

            if (curr == n - 1 && curc == n - 1)
                return curmoves;

            for (int i = 0; i < 8; i++) {

                int nextr = curr + dirr[i];
                int nextc = curc + dirc[i];
                if (isSafe(nextr, nextc) && (visited[nextr][nextc] == 0) && grid[nextr][nextc] == 0) {
                    visited[nextr][nextc] = 1;
                    q.add(new int[] { nextr, nextc, curmoves + 1 });
                }

            }

        }

        return -1;

    }
    
}
