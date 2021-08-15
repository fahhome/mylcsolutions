package leetcode;
import java.util.*;


public class WC31P2 {

    public boolean isEqualTree(TreeNode root, TreeNode subRoot){

        if( (null == root && null != subRoot)   ||    (null==subRoot  && null!= root)  )
            return false;
        

        if( null == root && null == subRoot)
            return true;

        if (root.val != subRoot.val)
            return false;

        return (isEqualTree(root.left, subRoot.left)  &&  isEqualTree(root.right, subRoot.right));

    }

    public void dfs(TreeNode root, TreeNode subRoot, boolean[] ans){

        boolean thisans = isEqualTree(root, subRoot);
        if(thisans == true)
            {
                ans[0] = true;
                return;
            }
        dfs(root.left, subRoot, ans);
        dfs(root.right,subRoot,ans);

    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        boolean[] ans = {false};
        dfs(root, subRoot, ans);
        return ans[0];

    }


    public static void main(String[] args) {
        
    }
}
