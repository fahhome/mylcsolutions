package leetcode;

import java.util.LinkedList;
import java.util.*;

public class W15P3 {

    static void dfs(String board, String hand, List<Character> cur , int index, int steps , int[] ans , int boardlength){


        if(cur.size() == 0){
            if(steps < ans[0])
                ans[0] = steps;
            
            return;
        }

        if( index >= cur.size())
            return;
        
        for(int i = 0; i <= hand.length() ; i++){

            if(i == hand.length()){
                dfs(board, hand, cur, index + 1, steps, ans, boardlength);
            }else{

                char handChar = hand.charAt(i);
                List<Character> tempcur = new LinkedList<>();
                for(int k = 0 ; k < cur.size(); k++)
                    tempcur.add(cur.get(k));
                tempcur.add(index, handChar);
                int lptr = index -1;
                int rptr = index +1;
                int llen = 0;
                int rlen = 0;
                int flag = 0;

                while(lptr >= 0  && tempcur.get(lptr) == handChar )
                    {
                        lptr--;
                        llen++;
                    }
                lptr++;
                while(rptr < tempcur.size() && tempcur.get(rptr) == handChar)
                    {
                        rptr++;
                        rlen++;
                    }

                if(llen + rlen >= 2){

                    int j = lptr;
                    flag =1 ;
                    while(j < tempcur.size() && tempcur.get(j) == handChar){
                        tempcur.remove(j);
                    }
                }

                if(flag == 1)
                    dfs(board, hand, new LinkedList<>(),lptr, steps+1, ans, boardlength);
                else
                    dfs(board, hand, tempcur, index+1, steps+1, ans, boardlength);


            }
            

        }

    }


    public static int findMinStep(String board, String hand) {

        int [] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        int boardlength = board.length();

        List<Character> cur = new LinkedList<>();

        for(int i = 0 ;  i < boardlength; i++)
            cur.add(board.charAt(i));

        dfs(board, hand, cur, 0, 0, ans, boardlength);

        if(ans[0] == Integer.MAX_VALUE)
            return -1;

        return ans[0];

    }

    public static void main(String[] args) {

        String board = "WW";
        String hand = "WRBRW";

        System.out.println(findMinStep(board, hand));
        
    }
}
