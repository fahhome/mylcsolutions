package leetcode;
import java.util.*;

// Important
// Note that it is a classic problem where DFS can be applied to solve it but it would end up traversing all paths to end
// But in BFS we can return the number of moves when we have reached the end cell, because from every state we are going to 
// other state with move + 1
public class SnakesAndLadder {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Reverse Board to get the 1 at the top because 1 is at the nth row so we want
        // 1 to be at 0th row.
        for (int i = 0; i < board.length / 2; i++) {
            int[] temp = board[i];
            board[i] = board[n - 1 - i];
            board[n - 1 - i] = temp;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 0 }); // Square (1..36), move
        Set<Integer> visited = new HashSet<Integer>();
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int square = cell[0];
            int move = cell[1];
            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                int[] newCell = getPosition(nextSquare, n);
                int r = newCell[0];
                int c = newCell[1];
                if (board[r][c] != -1)
                    nextSquare = board[r][c];
                if (nextSquare == n * n)
                    return move + 1;
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    q.add(new int[] { nextSquare, move + 1 });
                }
            }
        }

        return -1;
    }

    public int[] getPosition(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;

        if (row % 2 == 1)
            col = n - 1 - col;

        return new int[] { row, col };
    }
    
}
