package leetcode;
import java.util.*;

public class WC18AP2 {

    public static int treesum(TreeNode root){
        if(root == null)
            return 0;
        
        return root.val + treesum(root.left) + treesum(root.right);
    }

    public static void dfs(TreeNode root, LinkedHashMap<Integer,Integer> freqmap){
        if(root == null)
            return;
        
        int subtreesum = treesum(root);
        if(freqmap.containsKey(subtreesum)){
            freqmap.put(subtreesum, freqmap.get(subtreesum) + 1);
        }else{
            freqmap.put(subtreesum, 1);
        }

        dfs(root.left, freqmap);
        dfs(root.right, freqmap);

    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> anslist = new LinkedList<>();

        LinkedHashMap<Integer,Integer> freqMap = new LinkedHashMap<>();

        dfs(root, freqMap);

        Map<Integer, Integer> lhp = new LinkedHashMap<>();

        freqMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));
        
        Map.Entry<Integer,Integer> firstentry = lhp.entrySet().iterator().next();

        int highestFreq = firstentry.getValue();

        for(Map.Entry<Integer,Integer> entry : lhp.entrySet()){
            if(entry.getValue() != highestFreq)
                break;
            anslist.add(entry.getKey());
        }

        int[] ans = new int[anslist.size()];
        for(int i = 0 ; i < anslist.size(); i++)
            ans[i] = anslist.get(i);

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
