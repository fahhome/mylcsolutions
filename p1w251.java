package leetcode;
import java.util.*;

public class p1w251 {
    public static int transform(StringBuilder sdg) {
        int sum = 0;

        for(int i = 0; i< sdg.length(); i++){
            sum = sum + (sdg.charAt(i) - '0');
        }

        return sum;

    }

    public static String appenddigits(String s) {

        int sum = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append((s.charAt(i) - 96));
        }

        return new String(sb);
    }

    public static int getLucky(String s, int k) {
        StringBuilder sumdg = new StringBuilder(appenddigits(s));
        System.out.println(sumdg);
        int transform = 0;
        for (int i = 0; i < k; i++) {
            transform = transform(sumdg);
            System.out.println(sumdg);
            sumdg = new StringBuilder(String.valueOf(transform));
        }
        return transform;
    }


    public static void main(String[] args) {
        
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky(s, k));
    }
}
