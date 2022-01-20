package leetcode;

import java.util.*;

public class ZigZagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        if (root == null)
            return ans;
        bfs.offer(root);
        bfs.offer(null);
        int indicator = 0;

        while (!bfs.isEmpty()) {

            List<Integer> ansrow = new LinkedList<>();

            // If the nodes added from previous level are 0 then break the bfs
            if (bfs.peek() == null)
                break;

            while (null != bfs.peek()) {

                TreeNode node = bfs.poll();
                ansrow.add(node.val);
                if (node.left != null)
                    bfs.offer(node.left);
                if (node.right != null)
                    bfs.offer(node.right);

            }

            if (indicator % 2 == 0) {
                ans.add(ansrow);
            } else {
                Collections.reverse(ansrow);
                ans.add(ansrow);
            }

            bfs.poll();

            bfs.offer(null);

            indicator++;

        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
