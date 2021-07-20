package leetcode;

public class W16BP2 {

    public static int findmaxp1(int[] nums, int i , int j){
        if(i == j)
            return nums[i];
        if( i > j)
            return 0;

        int o1 = nums[i] + Math.min(  findmaxp1(nums, i+2, j) ,  findmaxp1(nums, i+1, j-1))  ;
        int o2 = nums[j] + Math.min( findmaxp1(nums, i, j-2) ,  findmaxp1(nums, i+1, j-1))  ;


        return Math.max(o1, o2);


    }


    public static boolean PredictTheWinner(int[] nums) {
        boolean ans = false;

        int totalarrsum = 0;

        int n = nums.length;
        for(int i = 0; i < n ; i++)
            totalarrsum +=  nums[i];

        int p1max = findmaxp1(nums, 0, n-1);

        System.out.println(p1max);
        if(p1max >= (totalarrsum - p1max))
            ans = true;

        return ans; 
    }

    public static void main(String[] args) {
        int [] nums = { 1, 5, 233, 7};
        System.out.println(PredictTheWinner(nums));
    }
}
