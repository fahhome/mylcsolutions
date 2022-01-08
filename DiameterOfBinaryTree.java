package leetcode;

public class DiameterOfBinaryTree {
    public int height(TreeNode root) {

        if (null == root)
            return 0;

        if (null == root.left && null == root.right)
            return 0;

        return Math.max(((null != root.left) ? 1 : 0) + height(root.left),
                ((null != root.right) ? 1 : 0) + height(root.right));
    }

    public void dfs(TreeNode root, int[] ans) {
        if (root == null)
            return;

        int maxwiththisroot = solve(root);

        if (maxwiththisroot > ans[0])
            ans[0] = maxwiththisroot;

        dfs(root.left, ans);
        dfs(root.right, ans);

    }

    public int solve(TreeNode root) {

        if (null == root)
            return 0;

        if (null == root.left && null == root.right)
            return 0;

        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        return ((null != root.left) ? 1 : 0) + height(root.left) + ((null != root.right) ? 1 : 0) + height(root.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        dfs(root, ans);

        return ans[0];
    }
    public static void main(String[] args) {
        
    }
}
