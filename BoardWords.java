package leetcode;
import java.util.*;

// For this problem use trie along with it to defeat TLE. 
public class BoardWords {
    int rows;
    int cols;
    List<String> ans;
    List<String> wordList;

    public boolean isSafe(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        return true;
    }

    public void dfs(char[][] board, StringBuilder curword, int[][] visited, int row, int col) {

        String curwordstr = new String(curword);
        if (wordList.contains(curwordstr)) {
            System.out.println(curwordstr);
            if (!ans.contains(curwordstr))
                this.ans.add(curwordstr);
        }

        // Up

        if (isSafe(row - 1, col) && visited[row - 1][col] == 0) {
            visited[row - 1][col] = 1;
            curword.append(board[row - 1][col]);
            dfs(board, curword, visited, row - 1, col);
            visited[row - 1][col] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Right

        if (isSafe(row, col + 1) && visited[row][col + 1] == 0) {
            visited[row][col + 1] = 1;
            curword.append(board[row][col + 1]);
            dfs(board, curword, visited, row, col + 1);
            visited[row][col + 1] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Down

        if (isSafe(row + 1, col) && visited[row + 1][col] == 0) {
            visited[row + 1][col] = 1;
            curword.append(board[row + 1][col]);
            dfs(board, curword, visited, row + 1, col);
            visited[row + 1][col] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

        // Left
        if (isSafe(row, col - 1) && visited[row][col - 1] == 0) {
            visited[row][col - 1] = 1;
            curword.append(board[row][col - 1]);
            dfs(board, curword, visited, row, col - 1);
            visited[row][col - 1] = 0;
            curword.deleteCharAt(curword.length() - 1);
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        wordList = Arrays.asList(words);
        rows = board.length;
        cols = board[0].length;
        this.ans = new LinkedList<>();
        StringBuilder curword = new StringBuilder();
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = 1;
                curword.append(board[i][j]);
                dfs(board, curword, visited, i, j);
                visited[i][j] = 0;
                curword.deleteCharAt(curword.length() - 1);
            }
        }

        return this.ans;

    }
    public static void main(String[] args) {
        
    }
}
