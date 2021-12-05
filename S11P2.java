package leetcode;

import java.util.*;

public class S11P2 {

    public static boolean isTwoTreeEqual(TreeNode root1, TreeNode root2){

        if( (root1 == null && root2 != null)  || ( root2 == null && root1 != null)  )
            return false;

        if( root1 == null && root2 == null)
            return true;

        if(root1.val != root2.val)
            return false;

        if( (root1.left == null && root2.left != null) || (root1.left != null && root2.left == null) ||
               (root1.right == null && root2.right != null) || (root1.right != null && root2.right == null) )
               return false;

        if(root1.left == null && root2.left == null && root1.right == null && root2.right == null)
            return true;

        
        return isTwoTreeEqual(root1.left, root2.left) && isTwoTreeEqual(root1.right, root2.right);
        

    }

    public static boolean dfs(TreeNode root, TreeNode subRoot){

        if(root == null)
            return false;
        
        if(isTwoTreeEqual(root, subRoot))
            return true;

        return dfs(root.left, subRoot) || dfs(root.right, subRoot);

    }


    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        return dfs(root, subRoot);
    }

    public static void main(String[] args) {
        
    }
    
}
