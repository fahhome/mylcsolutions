package leetcode;
import java.util.*;

public class NextClosestTime {

    public static String nxtClosestTime(String time){

        int hours = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(3, 5));

        int totmins = hours*60 + mins;

        HashSet<Integer> hset = new HashSet<>();

        for(char c : time.toCharArray())
            hset.add(c - '0');

        while(true){

            totmins = (totmins + 1) % (24*60);

            int[] timenow = new int[]{totmins/60/10,totmins/60%10,totmins%60/10,totmins%60%10};

            boolean flag = true;
            for(int i : timenow){
                if(!hset.contains(i))
                    flag = false;
            }

            if(flag == true){

                StringBuilder sb = new StringBuilder();
                for(int i =0 ;i < 2 ; i++)
                    sb.append(String.valueOf(timenow[i]));

                sb.append(":");

                for (int i = 2; i < 4; i++)
                    sb.append(String.valueOf(timenow[i]));

                return new String(sb);

            }
        }



    }

    public static void main(String[] args) {
        
    }
}
