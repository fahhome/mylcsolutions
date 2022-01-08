package leetcode;

//https://leetcode.com/problems/symmetric-tree/submissions/
public class CheckIfTreeIsSymmetric {
    public boolean symmdfs(TreeNode r1, TreeNode r2) {
        if (r1 != null && r2 == null)
            return false;
        if (r2 != null && r1 == null)
            return false;
        if (r1 == null && r2 == null)
            return true;
        if (r1.val != r2.val)
            return false;

        return symmdfs(r1.left, r2.right) && symmdfs(r1.right, r2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return symmdfs(root.left, root.right);
    }
}
