package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

//BFS
public class NearestExit {

    static boolean isSafe(int row, int col, int rows, int cols, char[][] maze) {

        if (row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == '.')
            return true;
        return false;
    }

    static boolean isNotBorder(int row, int col, int rows, int cols, char[][] maze){
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        return false;

    }


    public static int nearestExit(char[][] maze, int[] entrance) {
        int ans = -1;
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] visited = new int[rows][cols];

        int srow = entrance[0];
        int scol = entrance[1];

        Queue<int[]> q = new ArrayDeque<>();

        visited[entrance[0]][entrance[1]] = 1;

        //Up
        if( isSafe(srow-1, scol, rows, cols, maze) && visited[srow-1][scol] == 0 )
            {
                visited[srow-1][scol] = 1;
                q.add(new int[]{srow-1,scol,1});
            }
        if (isSafe(srow + 1, scol, rows, cols, maze) && visited[srow + 1][scol] == 0)
            {
                visited[srow + 1][scol] = 1;
                q.add(new int[] { srow + 1, scol, 1 });
            }
        if (isSafe(srow, scol-1, rows, cols, maze) && visited[srow][scol-1] == 0)
            {
                visited[srow][scol-1] = 1;
                q.add(new int[] { srow, scol-1, 1 });
            }
        if (isSafe(srow, scol + 1, rows, cols, maze) && visited[srow][scol + 1] == 0)
            {
                visited[srow][scol+1] = 1;
                q.add(new int[] { srow, scol + 1, 1 });
            }

        while(!q.isEmpty()){

            int [] front = q.poll();
            int row = front[0];
            int col = front[1];
            int dist = front[2];

            if(!isNotBorder(row-1, col, rows, cols, maze)  || !isNotBorder(row + 1, col, rows, cols, maze) || !isNotBorder(
                    row, col-1, rows, cols, maze)  || !isNotBorder(row, col + 1, rows, cols, maze)){
                ans = dist;
                break;
            }

            if (isSafe(row - 1, col, rows, cols, maze) && visited[row - 1][col] == 0) {
                visited[row - 1][col] = 1;
                q.add(new int[] { row - 1, col, dist+1 });
            }
            if (isSafe(row + 1, col, rows, cols, maze) && visited[row + 1][col] == 0) {
                visited[row + 1][col] = 1;
                q.add(new int[] { row + 1, col, dist+1 });
            }
            if (isSafe(row, col - 1, rows, cols, maze) && visited[row][col - 1] == 0) {
                visited[row][col - 1] = 1;
                q.add(new int[] { row, col - 1, dist+1 });
            }
            if (isSafe(row, col + 1, rows, cols, maze) && visited[row][col + 1] == 0) {
                visited[row][col + 1] = 1;
                q.add(new int[] { row, col + 1, dist+1 });
            }


        }


        return ans ;
    }
    public static void main(String[] args) {
        char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance= {1,0};

        System.out.println(nearestExit(maze, entrance));
    }
}
