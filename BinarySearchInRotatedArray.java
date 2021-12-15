package leetcode;
import java.util.*;

// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class BinarySearchInRotatedArray {

    public static int binarySearchWithBounds(int first, int last, int target, int [] nums){

        if(first >= nums.length || last < 0 )
            return -1;


        while(last >= first){
            int mid = first + (last-first)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] < target){
                first = mid+1;
            }else{
                last = mid -1;
            }
        }
        
        
        return -1;

    }


    public static int search(int[] nums, int target) {
        int indexOfnumsZero = -1 ;
        int len = nums.length;
        if(len == 0)
            return indexOfnumsZero;
        
        int l1,r1,l2,r2=0;
        
        int first = 0;
        int last = len - 1;
        while (last >= first) {
            int mid = first + (last - first) / 2;
            if(target == nums[mid])
                return mid;
            if (mid+1 < len && mid-1 >= 0 && (nums[mid+1]>nums[mid] && nums[mid-1] > nums[mid] ) ) {
                indexOfnumsZero = mid;
                break;
            }

            if (nums[mid] < nums[last]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

        }
        
        if(indexOfnumsZero == -1){
            l1 = 0;
            r1 = len-2;
            l2 = 0;
            r2 = len-2;
        }else{
            l1= 0; 
            r1= indexOfnumsZero-1;
            l2 = indexOfnumsZero +1;
            r2 = len-1;
        }
          
        int indexInLeftPartFromTroughPoint = binarySearchWithBounds(l1, r1, target, nums);
        int indexInRightPartFromTroughPoint = binarySearchWithBounds(l2, r2, target, nums);
        if( indexInLeftPartFromTroughPoint >= 0)
            return indexInLeftPartFromTroughPoint;
        else if(indexInRightPartFromTroughPoint >= 0)
            return indexInRightPartFromTroughPoint;
        else
            return -1;

        
    }
}
