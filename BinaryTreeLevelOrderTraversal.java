package leetcode;
import java.util.*;

// Use queue = new LinkedList<>() to add or offer null as a level end indicator(Refer PopulatingNextRightPointer.java)
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        TreeNode nullNode = new TreeNode(-2000);

        if (root == null)
            return ans;

        queue.add(root);
        queue.add(nullNode);

        while (!queue.isEmpty() && queue.peek().val != -2000) {

            List<Integer> row = new LinkedList<>();

            while (queue.peek().val != -2000) {
                TreeNode front = queue.poll();
                row.add(front.val);
                if (front.left != null)
                    queue.add(front.left);
                if (front.right != null)
                    queue.add(front.right);
            }

            ans.add(row);

            queue.poll();

            queue.add(nullNode);

        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
