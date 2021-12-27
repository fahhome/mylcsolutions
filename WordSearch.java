package leetcode;
import java.util.*;
public class WordSearch {
    int rows;
    int cols;
    String word;
    List<String> substrings;

    public boolean isSafe(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        return true;
    }

    public boolean dfs(char[][] board, StringBuilder curword, int[][] visited, int row, int col) {

        String curwordstr = new String(curword);
        if (word.equals(curwordstr)) {
            System.out.println(curwordstr);
            return true;
        }

        if (curwordstr.length() >= word.length())
            return false;

        if (!substrings.contains(curwordstr))
            return false;

        boolean isUp = false;
        boolean isRight = false;
        boolean isDown = false;
        boolean isLeft = false;

        // Up

        if (isSafe(row - 1, col) && visited[row - 1][col] == 0) {
            visited[row - 1][col] = 1;
            curword.append(board[row - 1][col]);
            isUp = dfs(board, curword, visited, row - 1, col);
            visited[row - 1][col] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Right

        if (isSafe(row, col + 1) && visited[row][col + 1] == 0) {
            visited[row][col + 1] = 1;
            curword.append(board[row][col + 1]);
            isRight = dfs(board, curword, visited, row, col + 1);
            visited[row][col + 1] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Down

        if (isSafe(row + 1, col) && visited[row + 1][col] == 0) {
            visited[row + 1][col] = 1;
            curword.append(board[row + 1][col]);
            isDown = dfs(board, curword, visited, row + 1, col);
            visited[row + 1][col] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Left
        if (isSafe(row, col - 1) && visited[row][col - 1] == 0) {
            visited[row][col - 1] = 1;
            curword.append(board[row][col - 1]);
            isLeft = dfs(board, curword, visited, row, col - 1);
            visited[row][col - 1] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        return isUp || isRight || isDown || isLeft;

    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.word = word;
        this.substrings = new LinkedList<>();
        for (int i = 1; i <= word.length(); i++) {
            String substr = word.substring(0, i);
            substrings.add(substr);
        }
        StringBuilder curword = new StringBuilder();
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = 1;
                curword.append(board[i][j]);
                boolean isFound = dfs(board, curword, visited, i, j);
                if (isFound == true)
                    return true;
                visited[i][j] = 0;
                curword.deleteCharAt(curword.length() - 1);
            }
        }

        return false;
    }
   public static void main(String[] args) {
       
   } 
}
