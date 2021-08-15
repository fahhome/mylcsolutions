package leetcode;

public class WC29P3 {


    public int longestLine(int[][] mat) {
        int ans = 0;

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] memohorizontal = new int[rows][cols];
        int[][] memovertical = new int[rows][cols];
        int[][] diagonal = new int[rows][cols];
        int[][] antidiagonal = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {

                // horizontal
                if (j - 1 < 0)
                    memohorizontal[i][j] = (mat[i][j] == 1 ? 1 : 0);
                else {
                    memohorizontal[i][j] = (mat[i][j] == 1 ? (1 + memohorizontal[i][j - 1]) : 0);
                }
                if (memohorizontal[i][j] > ans)
                    ans = memohorizontal[i][j];

                // vertical

                if (i - 1 < 0)
                    memovertical[i][j] = (mat[i][j] == 1 ? 1 : 0);
                else {
                    memovertical[i][j] = (mat[i][j] == 1 ? (1 + memovertical[i - 1][j]) : 0);
                }

                if (memovertical[i][j] > ans)
                    ans = memovertical[i][j];

                // diagonal

                if (i - 1 < 0 || j - 1 < 0) {
                    diagonal[i][j] = (mat[i][j] == 1 ? 1 : 0);
                } else {
                    diagonal[i][j] = (mat[i][j] == 1 ? (1 + diagonal[i - 1][j - 1]) : 0);

                }

                if (diagonal[i][j] > ans)
                    ans = diagonal[i][j];

                // antidiagonal

                if (i - 1 < 0 || j + 1 >= cols) {
                    antidiagonal[i][j] = (mat[i][j] == 1 ? 1 : 0);
                } else {
                    antidiagonal[i][j] = (mat[i][j] == 1 ? (1 + antidiagonal[i - 1][j + 1]) : 0);
                }

                if (antidiagonal[i][j] > ans)
                    ans = antidiagonal[i][j];

            }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
