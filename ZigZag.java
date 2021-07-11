package leetcode;

public class ZigZag {

    public static String convert(String s, int numRows) {
        String ans = "";
        int strlen = s.length();
        Character[][] charArr = new Character[numRows][strlen + 1];
        int sindex = 0;
        int col = -1;
        while (true) {

            for (int row = 0; (row < numRows) && (sindex < strlen); row++) {
                col++;
                charArr[row][col] = s.charAt(sindex);
                sindex++;
            }

            for (int j = numRows - 2; (sindex < strlen) && (j > 0); j--) {
                charArr[j][++col] = s.charAt(sindex);
                sindex++;
            }

            if (sindex >= strlen)
                break;

        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= col; j++) {
                if (charArr[i][j] != null) {
                    ans += charArr[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 1));
    }
    
}
