package leetcode;


// Connected horizontally or vertically 
public class Islands {

    static boolean isSafe(int row, int col , int rows, int cols){

        if(row >= 0 && row < rows && col >=0 && col < cols)
            return true;
        return false;
    }

    static void dfs(char[][] grid, int[][] visited , int rows, int cols, int srow, int scol){
        
        //Up
        if(isSafe(srow-1,scol,rows,cols) && visited[srow-1][scol] == 0 && grid[srow-1][scol] == '1' ){
            visited[srow-1][scol] = 1;
            dfs(grid, visited, rows, cols, srow-1, scol);
        }

        //Right

        if (isSafe(srow , scol+1, rows, cols) && visited[srow][scol+1] == 0 && grid[srow][scol+1] == '1') {
            visited[srow][scol+1] = 1;
            dfs(grid, visited, rows, cols, srow, scol + 1);
        }

        //Bottom

        if (isSafe(srow+1, scol, rows, cols) && visited[srow+1][scol] == 0 && grid[srow+1][scol] == '1') {
            visited[srow+1][scol] = 1;
            dfs(grid, visited, rows, cols, srow+1, scol);
        }

        // Left
        if (isSafe(srow, scol-1, rows, cols) && visited[srow][scol-1] == 0 && grid[srow][scol-1] == '1') {
            visited[srow][scol-1] = 1;
            dfs(grid, visited, rows, cols, srow, scol-1);
        }

    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        

        for(int i = 0 ; i< rows ; i++)
            for(int j = 0 ; j < cols; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    ans++;
                    dfs(grid, visited, rows, cols, i, j);
                }
            }
        

        return ans ;
    }
    public static void main(String[] args) {
        // char[][] grid = {
        //                     {'1','1','1','1','0'},
        //                     {'1','1','0','1','0'},
        //                     {'1','1','0','0','0'},
        //                     {'0','0','0','0','0'}
        //                 };
        
        char [][] grid = {{'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'} }; 

        System.out.println(numIslands(grid));
        
        
    }
}
