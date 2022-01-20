package leetcode;
import java.util.*;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new LinkedList<>();
        int len = currentState.length();
        int i = 0;
        while (i < len) {

            String modified = "";
            if (i + 2 <= len && currentState.substring(i, i + 2).equals("++")) {
                modified = currentState.substring(0, i) + "--" + currentState.substring(i + 2, len);
                ans.add(modified);
            }

            i++;
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
