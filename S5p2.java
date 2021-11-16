package leetcode;

import java.util.LinkedHashMap;
import java.util.*;

public class S5p2 {

    public static boolean numberExistsinBST(int n, TreeNode root) {
        if (root == null)
            return false;
        if (root.val == n)
            return true;

        // return (numberExists(n, root.left) || numberExists(n, root.right));

        if (n < root.val)
            return numberExistsinBST(n, root.left);
        else
            return numberExistsinBST(n, root.right);

    }

    public static void dfs(TreeNode root1, int k, int[] ans, TreeNode root2) {
        if (root1 == null)
            return;
        if (numberExistsinBST(k - root1.val, root2)) {
            ans[0] = 1;
            return;
        }
        dfs(root1.left, k, ans, root2);
        dfs(root1.right, k, ans, root2);
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if ((root1.left == null && root1.right == null) || (root2.left == null && root2.right == null))
            return false;

        int[] ans = new int[0];

        dfs(root1, target, ans, root2);

        if (ans[0] == 1)
            return true;

        return false;
    }
}
