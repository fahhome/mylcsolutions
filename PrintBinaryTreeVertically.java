package leetcode;
import java.util.*;

public class PrintBinaryTreeVertically {
    

    public static void fillmap(Node root, int col,
            TreeMap<Integer, List<SpecialNode>> colmap, int level) {

        if (root == null)
            return;

        if (colmap.containsKey(col)) {
            List<SpecialNode> oldlist = colmap.get(col);
            oldlist.add(new SpecialNode(root.data, level));
        } else {
            List<SpecialNode> newlist = new LinkedList<>();
            newlist.add(new SpecialNode(root.data, level));
            colmap.put(col, newlist);
        }

        fillmap(root.left, col - 1, colmap, level + 1);
        fillmap(root.right, col + 1, colmap, level + 1);

    }

    public static List<Integer> findVerticalTraversal(Node root) {
        // Write your code here...
        TreeMap<Integer, List<SpecialNode>> colmap = new TreeMap<>();
        fillmap(root, 0, colmap, 0);
        List<Integer> ans = new LinkedList<>();
        for (Map.Entry<Integer, List<SpecialNode>> entry : colmap.entrySet()) {
            List<SpecialNode> collist = entry.getValue();
            Collections.sort(collist, (node1, node2) -> {
                return node1.level - node2.level;
            });
            for (SpecialNode node : collist) {
                ans.add(node.val);
            }
        }

        return ans;

    }

    

    
    public static void main(String[] args) {
        
    }
}

class SpecialNode {
    int val;
    int level;

    SpecialNode(int val, int level) {
        this.val = val;
        this.level = level;
    }

}

class Node {
    int data; // data field
    Node left, right; // pointer to the left and right child

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
