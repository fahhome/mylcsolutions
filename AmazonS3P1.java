package leetcode;

public class AmazonS3P1 {

    public static boolean numberExists(int n, TreeNode root) {
        if (root == null)
            return false;
        if (root.val == n)
            return true;

        //return (numberExists(n, root.left) || numberExists(n, root.right));

        if( n < root.val)
            return numberExists(n, root.left);
        else
            return numberExists(n, root.right);

    }

    public static void dfs(TreeNode root, int k, int[] ans){
        if(root == null)
            return;
        if((k-root.val != root.val) && numberExists(k - root.val, root)){
            ans[0] = 1;
            return;
        }
        dfs(root.left, k, ans);
        dfs(root.right, k, ans);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root.left == null && root.right == null)
            return false;

        int[] ans = new int[1];

        dfs(root, k, ans);

        if (ans[0] == 1)
            return true;

        return false;

    }
    public static void main(String[] args) {
        
    }
}
