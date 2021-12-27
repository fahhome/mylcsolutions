package leetcode;
import java.util.*;
public class ExcelSheetColumnNumber {
    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('A', 1);
        values.put('B', 2);
        values.put('C', 3);
        values.put('D', 4);
        values.put('E', 5);
        values.put('F', 6);
        values.put('G', 7);
        values.put('H', 8);
        values.put('I', 9);
        values.put('J', 10);
        values.put('K', 11);
        values.put('L', 12);
        values.put('M', 13);
        values.put('N', 14);
        values.put('O', 15);
        values.put('P', 16);
        values.put('Q', 17);
        values.put('R', 18);
        values.put('S', 19);
        values.put('T', 20);
        values.put('U', 21);
        values.put('V', 22);
        values.put('W', 23);
        values.put('X', 24);
        values.put('Y', 25);
        values.put('Z', 26);
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            Character ch = columnTitle.charAt(i);
            sum += (Math.pow(26, len - i - 1) * values.get(ch));
        }

        return sum;
    }
    public static void main(String[] args) {
        
    }
}
