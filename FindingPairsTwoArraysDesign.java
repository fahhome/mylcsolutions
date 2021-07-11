package leetcode;

import java.util.Arrays;
// Using Cloning of Arrays 
// TLE
public class FindingPairsTwoArraysDesign {
    private int[] nums1;
    private int[] nums2;

    public FindingPairsTwoArraysDesign(int[] nums1, int[] nums2) {
        this.nums1 = new int[nums1.length];
        this.nums2 = new int[nums2.length];
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        
    }

    public void add(int index, int val) {
        nums2[index] += val;
        // Arrays.sort(nums2);
    }

    public int count(int tot) {
        int[] nums1clone = nums1.clone();
        int[] nums2clone = nums2.clone();
        Arrays.sort(nums1clone);
        Arrays.sort(nums2clone);
        int ans = 0;
        for (int i = 0; i < nums1clone.length; i++) {

            for (int j = nums2clone.length - 1; j >= 0; j--) {

                int sum = nums1clone[i] + nums2clone[j];
                if (sum == tot)
                    ans++;
                else if (sum < tot) {
                    break;
                } else {

                }

            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums1 = {1,1,2,2,2,3};
        int [] nums2 = {1,4,5,2,5,4};

        FindingPairsTwoArraysDesign obj = new FindingPairsTwoArraysDesign(nums1, nums2);
        System.out.println(obj.count(7));
    }
}
