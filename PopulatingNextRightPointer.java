package leetcode;
import java.util.*;
public class PopulatingNextRightPointer {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return root;

        q.add(root);
        q.add(null);

        while (!q.isEmpty() && q.peek() != null) {

            Node prev = null;
            while (q.peek() != null) {

                Node popped = q.poll();
                if (prev == null) {
                    prev = popped;
                } else {
                    prev.next = popped;
                    prev = popped;
                }

                q.add(popped.left);
                q.add(popped.right);
            }

            if (prev != null) {
                prev.next = null;
            }

            q.poll();
            q.add(null);

        }

        return root;

    }
    public static void main(String[] args) {
        
    }
}
