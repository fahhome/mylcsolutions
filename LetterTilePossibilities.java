package leetcode;
import java.util.*;

public class LetterTilePossibilities {
    public static void dfs(String tiles, int idx, int[] ans, int[] visited, StringBuilder sb, HashSet<String> hset) {
        if (idx > 0) {
            // System.out.println(sb);
            hset.add(new String(sb));
            ans[0] = Math.max(ans[0], hset.size());
        }

        if (idx >= tiles.length())
            return;

        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                sb.append(tiles.charAt(i));
                dfs(tiles, idx + 1, ans, visited, sb, hset);
                visited[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static int numTilePossibilities(String tiles) {
        int[] ans = new int[1];
        ans[0] = 0;
        int[] visited = new int[tiles.length()];
        HashSet<String> hset = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(tiles, 0, ans, visited, sb, hset);
        return ans[0];
    }
}
