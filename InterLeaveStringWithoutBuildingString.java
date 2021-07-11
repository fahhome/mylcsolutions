package leetcode;

import java.util.*;

public class InterLeaveStringWithoutBuildingString {

    public static void dfs(int i, int j, int l3, String s1, String s2, String s3, int[] ans) {

        if(ans[0] == 1)
            return;
        if (i + j == l3) {
            ans[0] = 1;
            return;
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && j < s2.length()
                && s2.charAt(j) == s3.charAt(i+j)) {
            dfs(i + 1, j, l3, s1, s2, s3, ans);
            dfs(i, j + 1, l3, s1, s2, s3, ans);
        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            dfs(i + 1, j, l3, s1, s2, s3, ans);
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            dfs(i, j + 1, l3, s1, s2, s3,  ans);
        } else {

        }

    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3)
            return false;

        if (l1 == 0 && l2 == 0 && l3 == 0)
            return true;

        if (l1 == 0 || l2 == 0) {
            if (s3.equals(s1) || s3.equals(s2))
                return true;
        }

        int[] ans = new int[1];

        dfs(0, 0, l3, s1, s2, s3, ans);

        if (ans[0] == 1)
            return true;

        return false;

    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcabcfg";

        System.out.println(isInterleave(s1, s2, s3));
    }
    
}
