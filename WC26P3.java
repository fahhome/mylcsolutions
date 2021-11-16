package leetcode;

// Number Of Provinces(Connected Components)
// IMPORTANT Graphs Adjacency matrix
public class WC26P3 {

    public void dfs(int city, int[] provinced, int[][] isConnected) {
        for (int i = 0; i < provinced.length; i++) {
            if (city != i && provinced[i] == 0 && isConnected[city][i] == 1) {
                provinced[i] = 1;
                dfs(i, provinced, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected[0].length;
        int[] provinced = new int[cities];
        int ans = 0;
        for (int i = 0; i < cities; i++) {
            if (provinced[i] == 0) {
                ans++;
                provinced[i] = 1;
                dfs(i, provinced, isConnected);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
