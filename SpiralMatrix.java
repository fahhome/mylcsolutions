package leetcode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

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
                list.add(matrix[startr][ltor++]);
                maxc++;
            }

            int ttob = startr + 1;
            int maxr = 2;
            while (maxr <= r) {
                ttobexecuted = true;
                list.add(matrix[ttob++][ltor - 1]);
                maxr++;
            }

            if (ttobexecuted) {
                int rtol = ltor - 2;
                maxc = 2;

                while (maxc <= c) {
                    rtolexecuted = true;
                    list.add(matrix[ttob - 1][rtol--]);
                    maxc++;
                }

                if (rtolexecuted) {
                    int btot = ttob - 2;
                    maxr = 1;
                    while (maxr <= r - 2) {
                        list.add(matrix[btot--][startc]);
                        maxr++;
                    }
                }

            }

            startr++;
            startc++;
            r -= 2;
            c -= 2;
        }

        return list;

    }
    public static void main(String[] args) {
        int[][] matrix = {{6,9,7}};

        System.out.println(spiralOrder(matrix));

    }
}
