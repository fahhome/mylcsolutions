package leetcode;
import java.util.*;

// k diff pairs -- can use hashmap
// If you comment out the overriden equals method then answer is different presumable because of set.contains on Pairh will not work properly then 
public class wc22p1 {
    public static int findPairs(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;

        HashSet<Pairh> set = new HashSet<>();
        for (int i = 0; i < len; i++) {

            
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k && !set.contains(new Pairh(nums[i], nums[j])) && !set
                        .contains(new Pairh(nums[j], nums[i]))) {
                    ans++;
                    set.add(new Pairh(nums[i], nums[j]));
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int [] nums = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3};

        int k = 3;

        System.out.println(findPairs(nums, k));
    }
}

class Pairh {
    public int numi;
    public int numj;

    public Pairh(int numi, int numj) {
        this.numi = numi;
        this.numj = numj;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numi;
        result = prime * result + numj;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pairh other = (Pairh) obj;
        if (numi != other.numi)
            return false;
        if (numj != other.numj)
            return false;
        return true;
    }
}
