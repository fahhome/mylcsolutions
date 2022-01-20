package leetcode;
import java.util.*;


// TLE but correct solution
// Add a Memo State to decrease 
public class MaximumSumBST {
    public int dfs(TreeNode root, int[] ans, int low, int high) {

        if (root == null)
            return 0;

        int flag = 0;
        if (root.val <= low || root.val >= high)
            flag = 1;

        int sumleft, sumright = Integer.MIN_VALUE;

        if (flag == 0) {
            sumleft = dfs(root.left, ans, low, root.val);
            sumright = dfs(root.right, ans, root.val, high);
        } else {
            sumleft = dfs(root.left, ans, Integer.MIN_VALUE, root.val);
            sumright = dfs(root.right, ans, root.val, Integer.MAX_VALUE);
        }


        if ((sumleft == Integer.MIN_VALUE || sumright == Integer.MIN_VALUE)
                && flag == 0) {// This current node can be the root of a new BST
            flag = 1;
            if (low != Integer.MIN_VALUE || high != Integer.MAX_VALUE) {
                System.out.println("Trying with root " + root.val);
                sumleft = dfs(root.left, ans, Integer.MIN_VALUE, root.val);
                sumright = dfs(root.right, ans, root.val, Integer.MAX_VALUE);
            }
        }

        System.out.println(root.val + " " + sumleft + " " + sumright);

        if (sumleft == Integer.MIN_VALUE || sumright == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        ans[0] = Math.max(ans[0], (root.val + sumleft + sumright));

        if (flag == 1)
            return Integer.MIN_VALUE;
        return root.val + sumleft + sumright;

    }

    public int maxSumBST(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = 0;
        dfs(root, ans, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans[0];
    }
    public static void main(String[] args) {
        
    }
}
