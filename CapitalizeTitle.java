package leetcode;
import java.util.*;

public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            String str = words[i];
            //String strtstr = words[i];
            int strlen = str.length();
            StringBuilder buf = new StringBuilder();
            if (strlen <= 2) {
                buf.append(str.toLowerCase());
            } else {
                char fc = str.charAt(0);
                buf.append(Character.toUpperCase(fc));
                for (int j = 1; j < strlen; j++) {
                    char ch = str.charAt(j);
                    buf.append(Character.toLowerCase(ch));
                }
            }

            if (i == len - 1) {
                sb.append(buf);
            } else {
                sb.append(buf);
                sb.append(" ");
            }
        }

        return new String(sb);
    }
}
