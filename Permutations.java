package leetcode;
import java.util.*;

public class Permutations {

    public void dfs(int[] nums, LinkedList<Integer> ansrow, int[] visited, List<List<Integer>> ans) {

        if (ansrow.size() == nums.length) {
            ans.add(new LinkedList<>(ansrow));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                ansrow.add(nums[i]);
                visited[i] = 1;
                dfs(nums, ansrow, visited, ans);
                visited[i] = 0;
                ansrow.removeLast();
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int[] visited = new int[nums.length];
        LinkedList<Integer> ansrow = new LinkedList<>();
        dfs(nums, ansrow, visited, ans);
        return ans;
    }

    public static void main(String[] args) {
        
    }
}


