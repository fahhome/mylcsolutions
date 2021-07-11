package leetcode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Set can contain unique List<integer> 
// possiblesoln and set are passed as references
// observe the line 19 set.add(new LinkedList<>(possiblesoln) );
public class CombinationSum {

    public static void dfs(int[] candidates, int target, int index, List<Integer> possiblesoln,
            Set<List<Integer>> set,int currentsum
            ){

                if(currentsum == target){
                    set.add(new LinkedList<>(possiblesoln) );
                }

                for(int i = index ; i < candidates.length; i++ ){
                    if(currentsum + candidates[i] <= target ){
                        possiblesoln.add(candidates[i]);
                        dfs(candidates, target, i, possiblesoln, set, currentsum+ candidates[i]);
                        possiblesoln.remove(possiblesoln.size() -1);
                    }
                }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> possiblesoln = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Set<List<Integer>> set = new LinkedHashSet<>();
        dfs(candidates, target, 0, possiblesoln, set, 0);
        ans = new LinkedList<>(set);
        return ans;
    }
    public static void main(String[] args) {
        int [] candidates = { 2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }


}
