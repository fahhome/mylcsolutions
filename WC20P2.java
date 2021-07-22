package leetcode;
import java.util.*;

public class WC20P2 {


    public static void dfsandbt(int index, int n, int[] visited, int[] ans){
        if(index > n){
            ans[0]++;
            return;
        }

        for(int i = 1; i <=n ; i++){
            if(visited[i] == 0 && ( (i%index == 0)  || (index%i == 0)) ){
                visited[i] = 1;
                dfsandbt(index+1, n, visited, ans);
                visited[i] = 0;
            }
        }

    }

    public static int countArrangement(int n) {

        int[] ans = new int[1];
        int[] visited = new int[n+2];

        dfsandbt( 1, n, visited, ans);

        return ans[0];

    }

    public static void main(String[] args) {
        System.out.println(countArrangement(5));
    }
}
