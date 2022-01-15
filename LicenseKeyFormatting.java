package leetcode;
import java.util.*;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        String[] parts = s.split("-");
        String combined = "";
        for (String str : parts)
            combined += str.toUpperCase();

        int len = combined.length();

        if (len <= k)
            return combined.substring(0, len);

        int sidx = len - k;
        int lidx = len;
        LinkedList<String> list = new LinkedList<>();

        while (sidx >= 0) {

            list.addFirst(combined.substring(sidx, lidx));

            if (sidx == 0)
                break;

            if (sidx - k >= 0) {
                lidx = sidx;
                sidx -= k;
            } else {
                lidx = sidx;
                sidx = 0;
            }

        }

        int anslen = list.size();
        String ans = "";
        for (int i = 0; i < anslen; i++) {
            if (i == anslen - 1)
                ans += list.get(i);
            else
                ans += list.get(i) + "-";
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }


}
