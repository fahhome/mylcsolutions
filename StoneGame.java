package leetcode;

//DP
// The problem statement should be if Alex can win the game and not if always Alex wins the game whatever move lee takes 
public class StoneGame {

    public static boolean stoneGame(int[] piles) {

        int len = piles.length;
        int sum  = 0;
        for(int i = 0 ; i < len ; i++)
            sum += piles[i];
        int [][]dp = new int[len][len]; 

        int offset = 1 ;

        while(offset < len){

            if(offset == 1){

                for(int i = 0 ; i< len ; i++){
                    if(i + offset < len){
                        dp[i][i+1] = Math.max(piles[i], piles[i+1]);
                    }
                }

            }
            else{

                // (0,3),(1,4) etc 

                for(int i = 0 ; i < len ; i++){
                    if(i + offset  <  len){
                        int min = 100000;
                        int a = piles[i] + dp[i + 1][i + offset - 1];// (1,2)
                        int b = piles[i] + dp[i + 2][i + offset ]; // (2,3)
                        int c = piles[i + offset] + dp[i + 1][i + offset - 1];// (1,2)
                        int d = piles[i + offset ] + dp[i][i + offset - 2]; // (0,1)

                        min = Math.max(Math.max(a,b),Math.max(c,d));

                        dp[i][i + offset] = min;
                    }
                    
                }
                
            }
            

            offset += 2;
        }

        if((dp[0][len-1]) > (sum - dp[0][len - 1]))
            return true ;
        return false ;
    }

    public static void main(String[] args) {
        int [] piles = {3,7,2,3};
        System.out.println(stoneGame(piles));
    }
    
}
