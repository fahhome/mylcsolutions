package leetcode;

public class TrappedWater {

    public static int trap(int[] height) {

        int arrLen = height.length;
        int[] leftmax = new int[arrLen];
        int[] rightmax = new int[arrLen];

        int leftMaximum = 0;
        int rightMaximum = 0;
        int trappedWater = 0;

        for (int i = 1; i < arrLen; i++) {
            if (height[i - 1] > leftMaximum)
                leftMaximum = height[i - 1];

            leftmax[i] = leftMaximum;

        }

        for (int i = arrLen - 2; i >= 0; i--) {
            if (height[i + 1] > rightMaximum)
                rightMaximum = height[i + 1];
            rightmax[i] = rightMaximum;
        }

        for (int i = 1; i < arrLen - 1; i++) {

            if (height[i] < Math.min(leftmax[i], rightmax[i]))
                trappedWater += (Math.min(leftmax[i], rightmax[i]) - height[i]);

        }

        return trappedWater;

    }

    public static void main(String[] args) {
        
    }
    
}
