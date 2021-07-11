package leetcode;

public class Pangram {
    public boolean checkIfPangram(String sentence) {

        boolean[] visited = new boolean[26];
        int count = 26;

        for (int i = 0; i < sentence.length(); i++) {
            Character ch = sentence.charAt(i);
            if (!visited[ch - 97]) {
                count--;
                visited[ch - 97] = true;
                if (count == 0)
                    break;
            }

        }

        if (count <= 0)
            return true;

        return false;
    }
    public static void main(String[] args) {
        
    }
}
