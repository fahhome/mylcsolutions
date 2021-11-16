package leetcode;
import java.util.*;

public class S7P2 {

    public int[][] generateMatrix(int n) {
        int[][] spiralMatrix = new int[n][n];

        int numberToInsert = 1;

        int rows = n;
        int cols = n;

        int startr = 0;
        int startc = 0;
        int r = rows;
        int c = cols;

        while (r > 0 && c > 0) {

            int ltor = startc;
            boolean ttobexecuted = false;
            boolean rtolexecuted = false;
            int maxc = 1;
            while (maxc <= c) {
                //list.add(matrix[startr][ltor++]);
                spiralMatrix[startr][ltor++] = numberToInsert++;
                maxc++;
            }

            int ttob = startr + 1;
            int maxr = 2;
            while (maxr <= r) {
                ttobexecuted = true;
                //list.add(matrix[ttob++][ltor - 1]);
                spiralMatrix[ttob++][ltor-1] = numberToInsert++;
                maxr++;
            }

            if (ttobexecuted) {
                int rtol = ltor - 2;
                maxc = 2;

                while (maxc <= c) {
                    rtolexecuted = true;
                    //list.add(matrix[ttob - 1][rtol--]);
                    spiralMatrix[ttob-1][rtol--] = numberToInsert++;
                    maxc++;
                }

                if (rtolexecuted) {
                    int btot = ttob - 2;
                    maxr = 1;
                    while (maxr <= r - 2) {
                        //list.add(matrix[btot--][startc]);
                        spiralMatrix[btot--][startc] = numberToInsert++;
                        maxr++;
                    }
                }

            }

            startr++;
            startc++;
            r -= 2;
            c -= 2;
        }

        return spiralMatrix;
    }

    public static void main(String[] args) {
        
    }
    
}
