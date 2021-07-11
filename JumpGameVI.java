package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVI {

    public static int maxResult(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int [] nums = {1,-1,-2,4,-7,3};
        System.out.println(maxResult(nums, 2));
    }
    
}


class JumpGameVIPair{
    public int value;
    public int index;
    public int sum ;

    public JumpGameVIPair(int value,int index, int sum){
        this.value = value;
        this.index = index ;
        this.sum = sum ;
    }
}
