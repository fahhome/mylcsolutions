package leetcode;
import java.util.*;

public class WC17P1 {

    public void dfs(TreeNode root, LinkedHashMap<Integer,Integer> freqmap) {

        if(root == null)
            return;

        if(freqmap.containsKey(root.val)){
            freqmap.put(root.val, freqmap.get(root.val) + 1);
        }else{
            freqmap.put(root.val, 1);
        }

        dfs(root.left, freqmap);
        dfs(root.right, freqmap);

    }


    public int[] findMode(TreeNode root) {

        LinkedHashMap<Integer,Integer> freqmap = new LinkedHashMap<>();
        Set<Integer> ansset = new LinkedHashSet<>();
        dfs(root, freqmap);
        int max = 0;
        List<Integer> anslist = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : freqmap.entrySet()){
            if(entry.getValue() > max){

                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : freqmap.entrySet()) {
            if (entry.getValue() == max) {

                ansset.add(entry.getKey());
            }
        }

        anslist = new LinkedList<>(ansset);

        int n = anslist.size();
        int[] ans = new int[n];

        for(int i = 0; i <n; i++)
            ans[i] = anslist.get(i);
        
        Arrays.sort(ans);
        return ans;

    }

    public static void main(String[] args) {
        
    }
}
