package leetcode;
import java.util.*;

public class WC19P1 {

    public static String convertToBase7(int num) {
        LinkedList<Integer> list = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        int absnum = Math.abs(num); 

        while(absnum > 0){
            int remainder = absnum % 7;
            list.add(0,remainder);
            
            
            absnum /= 7;

        }


        // Appends characters one by one
        if (num < 0)
            sb.append('-');
        for (Integer ch : list) {
            sb.append(String.valueOf(ch));
        }

        

        // convert in string
        String string = sb.toString();

        return string;
    }
    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
