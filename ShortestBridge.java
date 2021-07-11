package leetcode;

public class ShortestBridge {

    public static boolean isValid(int r, int c , int rows, int cols ){

        if(r >= rows || r < 0 || c >= cols || c < 0)
            return false;
        return true ;

    }

    public static void dfs(int[][] grid, int [][] visited){
    }

    public static int shortestBridge(int[][] grid) {
        int ans = 0;
        int rows  = grid.length;
        int cols = grid[0].length;
        int [][] visited = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++){
            for(int j=0; j < cols ; j++){
                if(visited[i][j] == 0){
                    visited[i][j] = 1 ;
                    dfs(grid, visited);                
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        
    }
}
