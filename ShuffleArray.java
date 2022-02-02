package leetcode;

public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ansarr = new int[len];

        int i = 0;
        int j = len / 2;
        int ctr = 0;

        while (i < len / 2) {

            ansarr[ctr++] = nums[i++];
            ansarr[ctr++] = nums[j++];
        }

        return ansarr;

    }
    
    public static void main(String[] args) {
        
    }
}
