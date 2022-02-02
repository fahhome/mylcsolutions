package leetcode;
import java.util.*;

public class MaximumPathSum {

    public int dfs(TreeNode root, int[] ans) {

        if (root == null)
            return 0;

        int leftMaxGain = dfs(root.left, ans);
        int rightMaxGain = dfs(root.right, ans);

        if (root.val > ans[0]) //  The path can only include the current node
            ans[0] = root.val;

        if (root.val + leftMaxGain > ans[0]) // The path can only include the cur node and the maximum path in its left subtree
            ans[0] = root.val + leftMaxGain;

        if (root.val + rightMaxGain > ans[0]) // The path can only include the cur node and the maximum path in its left
                                              // subtree
            ans[0] = root.val + rightMaxGain;

        if (root.val + leftMaxGain + rightMaxGain > ans[0]) {
            ans[0] = root.val + leftMaxGain + rightMaxGain;
        }

        int maxGainedFromThisNode = root.val;
        maxGainedFromThisNode = Math.max(maxGainedFromThisNode, root.val +
                Math.max(leftMaxGain, rightMaxGain));

        return maxGainedFromThisNode;

    }

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        dfs(root, ans);

        return ans[0];

    }

    public static void main(String[] args) {
        
    }
}
