package leetcode;

public class JuneTwelveThree {

        public static boolean isCovered(int[][] ranges, int left, int right) {
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;

        int rows = ranges.length;
        for (int i = 0; i < rows; i++) {

            if (ranges[i][0] < minLeft) {
                minLeft = ranges[i][0];
            }

            if (ranges[i][1] > maxRight)
                maxRight = ranges[i][1];

        }

        if (left >= minLeft && right <= maxRight)
            return true;

        return false;

    }

        public static void main(String[] args) {
            int[][] arr ={{1,10},{10,20}};
            System.out.println(isCovered(arr, 21, 21));
        }

}
