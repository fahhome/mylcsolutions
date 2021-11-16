package leetcode;

import java.util.*;

// Class based problem
public class MovingAverage {

    ArrayDeque<Integer> q ;
    int size;
    int sum;

    public  MovingAverage(int size) {
        this.q = new ArrayDeque<>(size);
        this.size = size;
        this.sum = 0;
    }



    public double next(int val) {

        if(q.size() >= size){
            sum -= q.pop();
        }
        q.add(val);
        sum += val;

        return (double)sum/q.size() ;

    }
}
