package leetcode;

public class DeepestLeavesSum {
    static int height;
    static int sum;

    public static int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + findHeight(root.left), 1 + findHeight(root.right));
    }

    public static void dfs(TreeNode root, int curheight) {
        if (root == null)
            return;
        if (curheight == height)
            sum += root.val;
        dfs(root.left, curheight + 1);
        dfs(root.right, curheight + 1);

    }

    public static int deepestLeavesSum(TreeNode root) {
        sum = 0;
        height = findHeight(root);
        dfs(root, 1);
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
