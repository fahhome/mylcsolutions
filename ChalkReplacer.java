package leetcode;

public class ChalkReplacer {

    public static int chalkReplacer(int[] chalk, int k) {
        int ans = 0;
        int sum = 0;
        int len = chalk.length;
        int remainingChalks = k;

        int[] prefixarr = new int[chalk.length];
        prefixarr[0] = chalk[0];

        for (int i = 0; i < len; i++) {
            sum += chalk[i];
            remainingChalks -= chalk[i];
            if (remainingChalks < 0) {
                return i;
            }
        }

        remainingChalks = remainingChalks % sum;

        for (int i = 0; i < len; i++) {
            remainingChalks -= chalk[i];
            if (remainingChalks < 0) {
                ans = i;
                break;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        // int [] chalk = {22,25,39,3,45,45,12,17,32,9};
        // int k = 835;

        int[] chalk = { 5, 1, 5 };
        int k = 22;

        // int[] chalk = { 3, 4, 1, 2};
        // int k = 25;

        System.out.println(chalkReplacer(chalk, k));
    }
    
}
