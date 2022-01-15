package leetcode;
import java.util.*;

class Solution {
    char[] cA1;
    char[] cA2;

    void swap(int i, int j) {
        char temp = cA1[i];
        cA1[i] = cA1[j];
        cA1[j] = temp;
    }

    int dfs(int i) {
        if (i == cA1.length) {
            return 0;
        }
        int ans = 21;
        if (cA1[i] != cA2[i]) {
            for (int j = i + 1; j < cA1.length; j++) {
                if (cA1[j] == cA2[i]) {
                    swap(i, j);
                    ans = Math.min(ans, 1 + dfs(i + 1));
                    swap(i, j);
                }
            }
        } else {
            ans = Math.min(ans, dfs(i + 1));
        }
        return ans;
    }

    public int kSimilarity(String s1, String s2) {
        cA1 = s1.toCharArray();
        cA2 = s2.toCharArray();
        int ans = dfs(0);
        return ans;
    }
}