package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// If you iterate via index and not : operator , then you dont need these extra spaces 
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        Collections.reverse(triangle);
        
        List<Integer> top = triangle.get(0);
        if(top.size() == 1)
            return top.get(0);
        
        List<Integer> lastrowdp = new ArrayList<>(top);

        triangle.remove(0);


        for(List<Integer> row : triangle){

            List<Integer> nextrowdp =  new ArrayList<>(row);

            for(int i = 0 ; i< nextrowdp.size(); i++){
                nextrowdp.set(i, row.get(i) + Math.min(lastrowdp.get(i), lastrowdp.get(i+1)));
            }

            lastrowdp = new ArrayList<>(nextrowdp);

        }


        return lastrowdp.get(0) ;

    }

    public static void main(String[] args) {
        
    }
    
}
