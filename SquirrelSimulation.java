package leetcode;

public class SquirrelSimulation {

    // when we choosing a nut which should be first visiting from the squirren the ans becomes
    // ans = ans + (SN + NT) - 2TN = ans + SN -TN;
    // So we need to minimize SN - TN for answer to be minimum
    public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = 0;

        int treer = tree[0];
        int treec = tree[1];

        int sqr = squirrel[0];
        int sqc = squirrel[1];

        int d = Integer.MAX_VALUE;

        for (int[] nut : nuts) {
            ans += 2 * (Math.abs(treer - nut[0]) + Math.abs(treec - nut[1]));
        }

        for (int[] nut : nuts) {
            d = Math.min(d, (Math.abs(sqr - nut[0]) + Math.abs(sqc - nut[1]))
                    - (Math.abs(nut[0] - treer) + Math.abs(nut[1] - treec)));
        }

        return ans + d;
    }

    public static void main(String[] args) {
        
    }


}
