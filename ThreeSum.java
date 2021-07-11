package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new LinkedList<>();
        HashSet<List<Integer>> hset = new LinkedHashSet<>();
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        int arrLen = nums.length;

        if (arrLen < 3)
            return lists;

        for (int i = 0; i < arrLen; i++) {
            if (freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            } else {
                freqMap.put(nums[i], 1);
            }
        }

        for (int i = 0; i < arrLen; i++) {

            int remsum = 0 - nums[i];

            for (int j = i + 1; j < arrLen; j++) {

                int pairno = remsum - nums[j];

                if(nums[i] == 0 && nums[j] == 0 ){
                    if (  freqMap.get(pairno) > 2 ) {
                        List<Integer> list = new LinkedList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(pairno);

                        Collections.sort(list);

                        if (!hset.contains(list)) {
                            lists.add(list);
                            hset.add(list);
                        }
                    }
                }
                else{
                    if (pairno == nums[j] || pairno == nums[i]) {

                        if (freqMap.get(pairno) > 1) {
                            List<Integer> list = new LinkedList<>();

                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(pairno);

                            Collections.sort(list);

                            if (!hset.contains(list)) {
                                lists.add(list);
                                hset.add(list);
                            }
                        }

                    } else {
                        if (freqMap.containsKey(pairno)) {
                            List<Integer> list = new LinkedList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(pairno);

                            Collections.sort(list);

                            if (!hset.contains(list)) {
                                lists.add(list);
                                hset.add(list);
                            }
                        }
                    }
                }
                
            }

        }

        return lists;

    }

    public static void main(String[] args) {

        int[] arr = { -1, 0, 1, 0};

        System.out.println(threeSum(arr));
        
    }
    
}
