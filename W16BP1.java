package leetcode;

public class W16BP1 {

    public int[] constructRectangle(int area) {
        int [] ans = new int[2];

        int l = area;
        int w = 1;

        while(l >= w){
            if(l*w == area){
                ans[0] = l ;
                ans[1] = w;
                l--;
                w++;
            }
            if(l*w > area)
                l--;
            else{
                w++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
