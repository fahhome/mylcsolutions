package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class TripletTLE {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new LinkedList<>();
        HashSet<List<Integer>> hset = new LinkedHashSet<>();

        int arrLen = nums.length;

        for (int i = 0; i < arrLen; i++) {
            for (int j = i + 1; j < arrLen; j++) {

                for (int k = j + 1; k < arrLen; k++) {

                    if ((nums[i] + nums[j] + nums[k]) == 0) {

                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        Collections.sort(list);

                        if(!hset.contains(list)){
                            lists.add(list);
                            hset.add(list);
                        }
                        
                    }
                    
                }
            }
        }

        return lists;

    }
    
    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
