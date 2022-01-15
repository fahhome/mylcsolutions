package leetcode;
import java.util.*;

public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {

        int tlen = target.length();
        int slen = source.length();

        int i = 0;
        int curj = 0;
        int ans = 0;
        int prevj = -1;
        while (curj < tlen && prevj != curj) {

            i = 0;
            prevj = curj;
            while (i < slen && curj < tlen) {
                if (source.charAt(i++) == target.charAt(curj)) {
                    curj++;
                }
            }

            if (curj == prevj)
                return -1;

            ans++;

        }

        return ans;

    }
    public static void main(String[] args) {
        
    }
}
