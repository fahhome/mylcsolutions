package leetcode;
import java.util.*;

public class ExcelColumnTitle {
    public String convertToTitle(int columnNumber) {

        HashMap<Integer, Character> hmap = new HashMap<>();

        hmap.put(1, 'A');
        hmap.put(2, 'B');
        hmap.put(3, 'C');
        hmap.put(4, 'D');
        hmap.put(5, 'E');
        hmap.put(6, 'F');
        hmap.put(7, 'G');
        hmap.put(8, 'H');
        hmap.put(9, 'I');
        hmap.put(10, 'J');
        hmap.put(11, 'K');
        hmap.put(12, 'L');
        hmap.put(13, 'M');
        hmap.put(14, 'N');
        hmap.put(15, 'O');
        hmap.put(16, 'P');
        hmap.put(17, 'Q');
        hmap.put(18, 'R');
        hmap.put(19, 'S');
        hmap.put(20, 'T');
        hmap.put(21, 'U');
        hmap.put(22, 'V');
        hmap.put(23, 'W');
        hmap.put(24, 'X');
        hmap.put(25, 'Y');
        hmap.put(26, 'Z');

        StringBuilder sb = new StringBuilder();



        while (columnNumber > 26) {

            int rem = columnNumber % 26;
            if (rem != 0) {
                sb.insert(0, hmap.get(rem));
                columnNumber /= 26;
            } else {// Edge case
                sb.insert(0, hmap.get(26));
                columnNumber = (columnNumber / 26) - 1;
            }

        }

        if (columnNumber > 0)
            sb.insert(0, hmap.get(columnNumber));

        return new String(sb);

    }
    public static void main(String[] args) {
        
    }
}
