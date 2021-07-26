package leetcode;

//https://leetcode.com/problems/construct-binary-tree-from-string/solution/
public class ConstructBinaryTreeFromString {
    public TreeNode construct(TreeNode root, String s, int index, int len) {
        if (index >= len)
            return null;

        if (s.charAt(index) == '-')
            return construct(root, s, index + 1, len);

        int value = 0;
        int temp = index;
        if ((index < len) && s.charAt(index) != ')' && s.charAt(index) != '(') {

            while (temp < len && s.charAt(temp) != ')' && s.charAt(temp) != '(') {

                value = value * 10 + (s.charAt(temp) - 48);

                temp++;
            }

        }

        int leafnodeflag = 0;

        if (temp >= len || s.charAt(temp) == ')')
            leafnodeflag = 1;

        if (leafnodeflag == 1) {
            if (index - 1 >= 0 && s.charAt(index - 1) == '-')
                return new TreeNode(-1 * value);
            else
                return new TreeNode(value);
        }

        // else built the left and right subtree
        int i = temp + 1;
        int j = temp + 2;

        if ((temp + 1 < len) && s.charAt(temp + 1) == '(')// has to be
            i = temp + 2;

        int lb = 1;
        int rb = 0;

        while (j < len && lb != rb) {
            if (s.charAt(j) == '(')
                lb++;
            else if (s.charAt(j) == ')')
                rb++;

            j++;
        }

        j = j + 1;
        if (j < len && s.charAt(j) == '-')
            j++;

        if (root == null) {
            if (index - 1 >= 0 && s.charAt(index - 1) == '-')
                root = new TreeNode(-1 * value);
            else
                root = new TreeNode(value);

        }

        root.left = construct(root.left, s, i, len);
        if (((j - 1) < len && s.charAt(j - 1) == '(')
                || ((j - 1) < len && s.charAt(j - 1) == '-' && s.charAt(j - 2) == '('))
            root.right = construct(root.right, s, j, len);
        else
            root.right = null;

        return root;

    }

    public TreeNode str2tree(String s) {
        int len = s.length();
        if (len < 1)
            return null;
        // TreeNode root = new TreeNode(Integer.valueOf(s.charAt(0) - 48));
        TreeNode root = null;
        root = construct(root, s, 0, len);

        return root;

    }
}
