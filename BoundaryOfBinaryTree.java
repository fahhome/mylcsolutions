package leetcode;
import java.util.*;

public class BoundaryOfBinaryTree {
    public void leftB(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        if (root.left != null) {
            list.add(root.val);
            leftB(root.left, list);
        } else if (root.right != null) {
            list.add(root.val);
            leftB(root.right, list);
        }

    }

    public void rightB(TreeNode root, List<Integer> list) {

        if (root == null)
            return;
        if (root.right != null) {
            rightB(root.right, list);
            list.add(root.val);
        } else if (root.left != null) {
            rightB(root.left, list);
            list.add(root.val);
        }

    }

    public void leaves(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        leaves(root.left, list);
        if (root.left == null && root.right == null)
            list.add(root.val);
        leaves(root.right, list);

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        list.add(root.val);

        leftB(root.left, list);
        leaves(root.left, list);
        leaves(root.right, list);
        rightB(root.right, list);

        return list;

    }
    public static void main(String[] args) {
        
    }
}
