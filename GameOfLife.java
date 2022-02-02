package leetcode;

public class GameOfLife {
    int rows;
    int cols;
    // int[] dirx;
    // int[] diry;

    public boolean isSafe(int row, int col) {

        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;

        return true;

    }

    public int liveNeighbors(int row, int col, int[][] db, int[] dirx, int[] diry) {
        int rows = db.length;
        int cols = db[0].length;
        int count = 0;

        for (int i = 0; i < 8; i++) {

            if (isSafe(row + dirx[i], col + diry[i]) && db[row + dirx[i]][col + diry[i]] == 1)
                count++;

        }

        return count;

    }

    public void gameOfLife(int[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        int[][] duplicateBoard = new int[rows][cols];

        int[] dirx = { -1, 0, 1, 0, -1, 1, 1, -1 };
        int[] diry = { 0, 1, 0, -1, 1, 1, -1, -1 };

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                duplicateBoard[i][j] = board[i][j];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {

                int liveNeighborsOfThis = liveNeighbors(i, j, duplicateBoard, dirx, diry);

                if (duplicateBoard[i][j] == 0) {
                    if (liveNeighborsOfThis == 3)
                        board[i][j] = 1;
                } else {
                    if (liveNeighborsOfThis < 2)
                        board[i][j] = 0;

                    if (liveNeighborsOfThis > 3)
                        board[i][j] = 0;
                }

            }

    }
}
