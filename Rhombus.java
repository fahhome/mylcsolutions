package leetcode;

import java.util.HashSet;

//Here the left edge was used to build the rhombuses 
// in some cases it fails
// The correct solution given in discuss considers the centre to build  the rhombuses
public class Rhombus {

    public static void compareSwap(int[] ans, int sum, HashSet set) {
        if(!set.contains(sum)){
            if (sum > ans[0]) {
                set.add(sum);
                ans[1] = ans[0];
                ans[0] = sum;
            } else if (sum > ans[1] && sum != ans[0]) {
                set.add(sum);
                ans[2] = ans[1];
                ans[1] = sum;
            } else if (sum > ans[2] && sum != ans[1]) {
                set.add(sum);
                ans[2] = sum;
            } else {

            }
        }
    }

    public static int[] getBiggestThree(int[][] grid) {
        int [] ans = new int[3];
        HashSet<Integer> set = new HashSet<>();
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MIN_VALUE;
        ans[2] = Integer.MIN_VALUE;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] startedwith = new boolean[rows][cols];


        for(int i = 0 ; i < rows ; i++){
            for(int j = 0; j < cols; j++){

                 if(startedwith[i][j] == false ){
                    startedwith[i][j] = true;
                    compareSwap(ans, grid[i][j],set);
                 }

                 int maxRight = cols - 1 - j ;

                 int curRight = maxRight;

                //  if(curRight % 2 != 0)
                //     curRight -= 1;

                 while(curRight > 0){

                    int verticaldisp = (int)Math.ceil(curRight/2);

                    
                    if(i - verticaldisp >=0 && i+ verticaldisp < rows){
                        int sum = grid[i][j] ;
                        int k = 1;
                        for(k = 1; k <= verticaldisp; k++){
                            sum+= grid[i-k][j+k];
                        }
                        int tpcol = j + k -1 ;
                        int tprow = i - k +1 ;

                        k = 1;
                        for (k = 1; k <= verticaldisp; k++) {
                            sum += grid[tprow + k][tpcol + k];
                        }

                        int rcol = tpcol + k  -1 ;
                        int rrow = tprow + k  -1 ;

                        k = 1 ;

                        for (k = 1; k <= verticaldisp; k++) {
                            sum += grid[rrow + k][rcol - k];
                        }

                        int bcol = rcol - k + 1;
                        int brow = rrow +k -1;

                        k = 1;

                        for (k = 1; k < verticaldisp; k++) {
                            sum += grid[brow - k][bcol - k];
                        }
                        
                        compareSwap(ans, sum, set);

                    }
                    else{

                    }

                    curRight -= 1;
                 }


            }
        }

        if(ans[1] == Integer.MIN_VALUE){
            int [] ansone = new int[1];
            ansone[0] = ans[0];
            return ansone;
        }
        if(ans[2] == Integer.MIN_VALUE){
            int[] anstwo = new int[2];
            anstwo[0] = ans[0];
            anstwo[1] = ans[1];
            return anstwo;
        }

        return ans ;
    }
    public static void main(String[] args) {
        //int [][] grid =  {{1,2,3},{4,5,6},{7,8,9}};

        int [][] grid = {{20,17,9,13,5,2,9,1,5},{14,9,9,9,16,18,3,4,12},{18,15,10,20,19,20,15,12,11},{19,16,19,18,8,13,15,14,11},{4,19,5,2,19,17,7,2,2}};

        int[]arr = getBiggestThree(grid);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
