package leetcode;

public class W18BP4 {

    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int len = rows*cols;
        int[] ans = new int[len];


        int isup = 1 ;
        int ctr = 0;

        int srow = 0;
        int scol = 0;
        
        while(ctr < len){

            if(isup % 2 == 1){
                while(srow >= 0 && scol < cols){
                    ans[ctr++] = mat[srow][scol];
                    if(ctr == len)
                        break;
                    srow--;
                    scol++;
                }

                if(scol == cols){
                    srow = srow +2;
                    scol = scol -1;
                }else{
                    srow = srow +1;
                    scol = scol;
                }

            }else{

                while (srow < rows && scol >= 0) {
                    ans[ctr++] = mat[srow][scol];
                    if (ctr == len)
                        break;
                    srow++;
                    scol--;
                }

                if (srow == rows) {
                    srow = srow - 1;
                    scol = scol + 2;
                } else {
                    srow = srow;
                    scol = scol+1;
                }

            }


            isup++;

        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
