package leetcode;
import java.util.*;

public class BW59P1 {

    public static int minTimeToType(String word) {
        int ans = 0;

        int len = word.length();

        int pointer = 0; // 0 and 27


        for(int i = 0 ; i < len; i++ ){
            int indchar = word.charAt(i) - 'a';
            ans = ans + Math.min(Math.abs(pointer - indchar) , Math.min(Math.abs(indchar - (pointer + 26) ), Math.abs(indchar + 26 - pointer)   ) ) + 1;
            pointer = indchar;
        }

        return ans;
    }

    public static void main(String[] args) {
        String word = "zjpc";
        System.out.println(minTimeToType(word));
    }
}
