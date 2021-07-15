package leetcode;
import java.util.*;

public class W16A {

    public static void solve(int[] nums, int len, Set<List<Integer>> lsoln, List<Integer> ssoln, int index ){

        if(index >= len)
            return;
        
        if(ssoln.size() == 0 || (ssoln.size() > 0 && (nums[index] - ssoln.get(ssoln.size()-1) >= 0 )  ) ){
            if(ssoln.size() == 0){
                ssoln.add(nums[index]);
                solve(nums, len, lsoln, ssoln, index + 1);
                ssoln.remove(ssoln.size() - 1);
                solve(nums, len, lsoln, ssoln, index + 1);
            }else{
                ssoln.add(nums[index]);
                lsoln.add(new LinkedList<>(ssoln));
                solve(nums, len, lsoln, ssoln, index + 1);
                ssoln.remove(ssoln.size() - 1);
                solve(nums, len, lsoln, ssoln, index + 1);
            }
            
        }else{
            solve(nums, len, lsoln, ssoln, index + 1);
        }

    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lsolnlist = new LinkedList<>();
        int len = nums.length;
        List<Integer> ssoln = new LinkedList<>();

        Set<List<Integer>> lsoln = new HashSet<>();

        solve(nums, len, lsoln, ssoln, 0);

        return new LinkedList<>(lsoln);
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
