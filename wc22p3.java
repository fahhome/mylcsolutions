package leetcode;

public class wc22p3 {

    public int findBlackPixel(char[][] picture, int target) {
        int ans = 0;

        int rows = picture.length;
        int cols = picture[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (picture[i][j] == 'B') {
                    int flag = 1;
                    int count = 0;
                    for(int k = 0; k < cols; k++){
                        if(picture[i][k] == 'B')
                            count++;
                    }

                    if(count != target)
                        {
                            flag = 0;
                            continue;
                        }
                    
                    count = 0;
                    for(int k = 0; k < rows; k++){
                        if(picture[k][j] == 'B')
                            count++;
                    }

                    if(count != target)
                        {
                            flag = 0;
                            continue;
                        }
                    
                    int[] row = new int[cols];

                    for(int k = 0; k < cols; k++)
                        row[k] = picture[i][k];

                    for(int k= 0 ; k< rows; k++){
                        if(picture[k][j] == 'B'){

                            for(int l = 0; l<cols; l++){
                                if(row[l] != picture[k][l]){
                                    flag = 0;
                                    break;
                                }
                            }

                            if(flag == 0)
                                continue;


                        }
                    }
                    

                    if (flag == 1)
                        ans++;

                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        
    }
}
