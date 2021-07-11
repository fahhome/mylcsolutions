package leetcode;

import java.util.*;

public class MinimumXORSum {



    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    public static void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {

        // Base case
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (resultList.contains(arr[i])) {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    public static int minimumXORSum(int[] nums1, int[] nums2) {
        int ans  = Integer.MAX_VALUE;
        List<List<Integer>> permute = permute(nums2);
        int len = nums1.length;
        for (List<Integer> perm : permute){
            int sum = 0;
            for(int i= 0 ; i < len ; i++){
                sum += nums1[i] ^ perm.get(i);
            }
            if( sum < ans)
                ans = sum;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 0, 3 };
        int[] nums2 = { 5, 3, 4};

        System.out.println(minimumXORSum(nums1, nums2));
        
    }
    
}
