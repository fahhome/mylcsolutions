package leetcode;

public class DeleteLeafNodesRecurring {
    
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return root;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target)
            root = null;

        return root;

    }

}


// because the reference is sent as value , you cannot expect  root.left to become null when you do root = null on a recursive call