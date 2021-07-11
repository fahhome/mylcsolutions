package leetcode;

//Not Working for all cases
public class MedianSortedArrays {


    private static boolean IsOdd(int x){
        return x%2 == 0 ? true : false ;
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {

        double ans = 0.0;
        
        int aLen = A.length;
        int bLen = B.length;

        if (aLen > bLen){
            int [] temp = B ;
            B  = A ;
            A = temp ;

            int tempvar = bLen;
            bLen = aLen;
            aLen = tempvar ;
        }

        int leftHalfLen = (aLen + bLen + 1) / 2;

        int aMinCount = 0;
        int aMaxCount = aLen;

        while (aMinCount <= aMaxCount)
        {
            int aCount = aMinCount + ((aMaxCount - aMinCount) / 2);
            int bCount = leftHalfLen - aCount;

            Integer x = (aCount > 0) ? A[aCount - 1] : null;
            Integer y = (bCount > 0) ? B[bCount - 1] : null;

            Integer xP = (aCount < aLen) ? A[aCount] : null;
            Integer yP = (bCount < bLen) ? B[bCount] : null;
            if (x!=null && yP !=null && x > yP) {
                // Decrease A's contribution size; x lies in the right half.
                aMaxCount = aCount - 1;
            } else if (y!= null && xP!= null &&  y > xP) {
                // Decrease B's contribution size, i.e. increase A's contribution size;
                // y lies in the right half.
                aMinCount = aCount + 1;
            } else {
                //
                // Neither x nor y lie beyond the left half. We found the right aCount.
                // We don't know how x and y compare to each other yet though.
                //

                //
                // If aLen + bLen is odd, the median is the greater of x and y.
                // Remember that either x or y can be null (if A or B is not contributing).
                //
                int leftHalfEnd = (x == null) ? y : (y == null) ? x : Math.max(x, y);

                if (IsOdd(aLen + bLen)) {
                    ans = leftHalfEnd/1.00000;
                }

                //
                // aLen + bLen is even. To compute the median, we need to find
                // the first element in the right half, which will be the smaller
                // of xP and yP. Remember that either xP or yP can be null (if all
                // the values of A or B are in the left half).
                //
                else{
                    int rightHalfStart = (xP == null) ? yP : (yP == null) ? xP : Math.min(xP, yP);
                    ans = (leftHalfEnd + rightHalfStart) / 2.0;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        int [] nums1 = { 1, 3};
        int [] nums2 = { 2 };

        System.out.println(findMedianSortedArrays(nums1, nums2));
        
    }
}
