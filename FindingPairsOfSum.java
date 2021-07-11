package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindingPairsOfSum{

    private int [] nums1 ;
    private int [] nums2 ;

    private Map<Integer,Integer> map ;
    public FindingPairsOfSum(int[] nums1 , int[] nums2){
        this.nums1 = new int[nums1.length];
        this.nums2 = new int[nums2.length];

        this.nums1 = nums1;
        this.nums2 = nums2;

        map = new LinkedHashMap<>();

        for(int i : nums2){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i)+1);
        }


    }

    public void add(int index, int val) {
        int prev = nums2[index];
        nums2[index] = prev +  val;
        map.put(prev, map.get(prev)-1);

        if (!map.containsKey(nums2[index]))
            map.put(nums2[index], 1);
        else
            map.put(nums2[index], map.get(nums2[index]) + 1);
    }


    public int count(int tot) {
        
        int ans = 0;
        for(int i = 0 ; i< nums1.length; i++){
            int pivot = nums1[i];
            int required = tot-pivot;

            if(map.containsKey(required)){
                ans = ans + map.get(required);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        int[] nums1 = { 1, 1, 2, 2, 2, 3 };
        int[] nums2 = { 1, 4, 5, 2, 5, 4 };

        FindingPairsOfSum obj = new FindingPairsOfSum(nums1, nums2);
        System.out.println(obj.count(7));
        
    }
}