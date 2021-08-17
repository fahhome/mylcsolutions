package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

//Accepted
// 01 Matrix(LC name) 
public class BooleanMatrix {

    static boolean isSafe(int row, int col, int rows, int cols) {

        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        return false;
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] isUpdated = new int[mat.length][mat[0].length];
        int rows = mat.length;
        int cols = mat[0].length;
        int [][] updated = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++)
            for(int j = 0 ; j < cols; j++){
                if(mat[i][j] == 0){
                    isUpdated[i][j] =1 ;
                    updated[i][j] = 0;
                }else{
                    
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j,0});
                    q.add(new int[]{-1,-1,-1}); // level end indicator
                    int [][] visited = new int[rows][cols];
                    visited[i][j] =1 ;

                    while(!q.isEmpty() && q.peek()[2] != -1){
                        int[] popinlevel = q.poll();
                        int flag = 0 ;
                        while (popinlevel[2] != -1) {
                            int srow = popinlevel[0];
                            int scol = popinlevel[1];
                            int dist = popinlevel[2];

                            if(mat[srow][scol] == 0){
                                isUpdated[i][j] = 1 ;
                                updated[i][j] = dist;
                                flag =1 ;
                                break;
                            }else{
                                if (isSafe(srow - 1, scol, rows, cols) && visited[srow - 1][scol] == 0) {
                                    visited[srow - 1][scol] = 1;
                                    q.add(new int[] { srow - 1, scol, dist + 1 });
                                }

                                // Right

                                if (isSafe(srow, scol + 1, rows, cols) && visited[srow][scol + 1] == 0) {
                                    visited[srow][scol + 1] = 1;
                                    q.add(new int[] { srow, scol + 1, dist + 1 });
                                }

                                // Bottom

                                if (isSafe(srow + 1, scol, rows, cols) && visited[srow + 1][scol] == 0) {
                                    visited[srow + 1][scol] = 1;
                                    q.add(new int[] { srow + 1, scol, dist + 1 });
                                }

                                // Left
                                if (isSafe(srow, scol - 1, rows, cols) && visited[srow][scol - 1] == 0) {
                                    visited[srow][scol - 1] = 1;
                                    q.add(new int[] { srow, scol - 1, dist + 1 });
                                }
                            }

                            popinlevel = q.poll();
                        }
                        if(flag == 1)
                            break;
                        q.add(new int[] { -1, -1, -1 });
                        //q.poll();
                    }    
                }
            }

        return updated;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        // [[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]
        System.out.println(updateMatrix(mat));
    }
}
