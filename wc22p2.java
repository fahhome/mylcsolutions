package leetcode;

public class wc22p2 {
    public static int findLonelyPixel(char[][] picture) {
        int ans = 0;
        int rows = picture.length;
        int cols = picture[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(picture[i][j] == 'B'){
                    int flag = 1;
                    for(int k = 0 ; k < cols; k++){
                        if(picture[i][k] == 'B' && k!=j)
                            flag = 0;
                    }

                    for (int k = 0; k < rows; k++) {
                        if (picture[k][j] == 'B' && k != i)
                            flag = 0;
                    }

                    if(flag == 1)
                        ans++;

                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
