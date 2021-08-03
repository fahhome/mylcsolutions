package leetcode;
import java.util.*;


// https://leetcode.com/contest/leetcode-weekly-contest-25/problems/boundary-of-binary-tree/
public class BoundaryTree {
    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + findHeight(root.left), 1 + findHeight(root.right));
    }

    public void addLeft(TreeNode root, LinkedHashMap<Integer, Integer> leftlevelmap, LinkedList<Integer> ans, int level,
            int ht, int isleftchild) {

        if (root == null)
            return;

        if ((null != root.left || null != root.right))
            ans.add(root.val);

        if (null != root.left)
            addLeft(root.left, leftlevelmap, ans, level + 1, ht, 1);
        else if (null != root.right)
            addLeft(root.right, leftlevelmap, ans, level + 1, ht, 0);
    }

    public void addLeaves(TreeNode root, LinkedList<Integer> ans, int level, int ht) {

        if (root == null)
            return;

        if (null == root.left && null == root.right)
            ans.add(root.val);

        addLeaves(root.left, ans, level + 1, ht);
        addLeaves(root.right, ans, level + 1, ht);

    }

    public void addRight(TreeNode root, LinkedHashMap<Integer, Integer> rightlevelmap, LinkedList<Integer> ans,
            int level, int ht) {

        if (root == null)
            return;

        if (null != root.right)
            addRight(root.right, rightlevelmap, ans, level + 1, ht);
        else if (null != root.left)
            addRight(root.left, rightlevelmap, ans, level + 1, ht);

        if (!rightlevelmap.containsKey(level) && (null != root.left || null != root.right)) {
            rightlevelmap.put(level, 1);
            ans.add(root.val);

        }

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(root.val);

        int height = findHeight(root);

        if (height == 1)
            return ans;

        LinkedHashMap<Integer, Integer> leftlevelmap = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> rightlevelmap = new LinkedHashMap<>();

        addLeft(root.left, leftlevelmap, ans, 1, height, 1);
        addLeaves(root, ans, 1, height);
        addRight(root.right, rightlevelmap, ans, 1, height);

        return ans;
    }
}
