package leetcode;

// Passed All test cases 
// But for O(n) solution refer the link below
// https://leetcode.com/problems/validate-binary-search-tree/solution/
public class ValidBST {
    public boolean isLeftSatisfy(TreeNode root, int val) {
        if (root == null)
            return true;
        if (root.val >= val)
            return false;
        return isLeftSatisfy(root.left, val) && isLeftSatisfy(root.right, val);
    }

    public boolean isRightSatisfy(TreeNode root, int val) {
        if (root == null)
            return true;
        if (root.val <= val)
            return false;
        return isRightSatisfy(root.left, val) && isRightSatisfy(root.right, val);
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        boolean left = isLeftSatisfy(root.left, root.val);
        boolean right = isRightSatisfy(root.right, root.val);

        if (left == false || right == false)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);

    }
    public static void main(String[] args) {
        
    }
}
