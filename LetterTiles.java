package leetcode;

public class LetterTiles {

    public static void dfs(String tiles, int idx, int[] ans, int[] visited,StringBuilder sb) {
        if (idx > 0)
            {
                ans[0]++;
                System.out.println(sb);
            }

        if (idx >= tiles.length())
            return;

        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                sb.append(tiles.charAt(i));
                dfs(tiles, idx + 1, ans, visited,sb);
                visited[i] = 0;
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

    public static int numTilePossibilities(String tiles) {
        int[] ans = new int[1];
        ans[0] = 0;
        int[] visited = new int[tiles.length()];
        StringBuilder sb = new StringBuilder();
        dfs(tiles, 0, ans, visited,sb);
        return ans[0];
    }

    public static void main(String[] args) {
        String tiles = "AB";
        System.out.println(numTilePossibilities(tiles));

    }
}
