package leetcode;

public class FindFirstLastTarget {
    // Binary search strong grip
    public static int getIndexOf(int number, int[] nums){
        int index = -1 ;
        int len = nums.length;
        if(len == 0)
            return index;

        int first = 0;
        int last = len - 1;
        while (last >= first) {
            int mid = first + (last - first) / 2;

            if (nums[mid] == number) {
                index = mid;
                break;
            }

            if (nums[mid] > number) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

        }

        return index;

    }

    public static int getIndexOfNextLarger(int number, int[] nums, int first , int last){
        int index = -1 ;
        int len = nums.length ;

        if(len == 0)
            return index;
        
        while (last >= first) {
            int mid = first + (last - first) / 2;

            if (mid < len-1 && nums[mid] == number && nums[mid+1] != number) {
                index = mid;
                break;
            }

            if (nums[mid] != number) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

        }

        return index ;
    }

    public static int getIndexOfPreviousSmaller(int number, int[] nums, int first, int last) {
        int index = -1;
        int len = nums.length;

        if (len == 0)
            return index;

        while (last >= first) {
            int mid = first + (last - first) / 2;

            if (mid > 0 && nums[mid] == number && nums[mid - 1] != number) {
                index = mid;
                break;
            }

            if (nums[mid] == number) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

        }

        return index;
    }


    public static int[] searchRange(int[] nums, int target) {
        int len  = nums.length;
        int foundindex = -1;
        int rightindex = -1;
        int leftindex = -1;
        int [] ans = {-1,-1};

        foundindex = getIndexOf(target, nums);

        if(foundindex == -1)
            return ans ;

        rightindex = getIndexOfNextLarger(target, nums , foundindex , len-1);
        if(rightindex == -1)
            rightindex = len-1 ;
        
        leftindex = getIndexOfPreviousSmaller(target, nums, 0, foundindex);
        if(leftindex == -1)
            leftindex = 0 ;
        
        ans[0] = leftindex;
        ans[1] = rightindex ; 
        
        return ans ;
    }
    public static void main(String[] args) {

        int [] nums = {5,7,7,8,8,10,12,15}; 
        int target = 8 ;
        int[] ans = searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
        
    }
}
