package leetcode;

public class DeleteLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return root;

        if (root.left != null && root.left.val == target && root.left.left == null && root.left.right == null)
            root.left = null;
        if (root.right != null && root.right.val == target && root.right.left == null && root.right.right == null)
            root.right = null;

        TreeNode lnode = removeLeafNodes(root.left, target);
        TreeNode rnode = removeLeafNodes(root.right, target);

        return root;

    }
    
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      
}
