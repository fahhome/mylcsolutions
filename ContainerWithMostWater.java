package leetcode;


// Double to Int  --> (int)

// Proof by contradiction 
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        long maxArea = 0;

        int leftptr = 0;
        int xLen = height.length;
        int rightptr = xLen - 1;

        while (leftptr < rightptr) {

            long currentArea = (rightptr - leftptr) * Math.min(height[leftptr], height[rightptr]);

            if (currentArea > maxArea)
                maxArea = currentArea;

            if (height[leftptr] < height[rightptr])
                leftptr++;
            else if (height[leftptr] > height[rightptr])
                rightptr--;
            else {
                leftptr++;
                rightptr--;
            }

        }

        return (int) maxArea;
    }

    public static void main(String[] args) {
        
    }
    
}
