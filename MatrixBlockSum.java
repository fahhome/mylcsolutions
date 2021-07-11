package leetcode;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                ans[i][j] = 0;

                for (int r = i - k; r <= i + k; r++) {
                    for (int c = j - k; c <= j + k; c++) {

                        if (r >= 0 && r < rows && c >= 0 && c < cols)
                            ans[i][j] += mat[r][c];

                    }
                }

            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
