package leetcode;
import java.util.*;


//MLE with BFS 
// Lets try DFS
public class WC31P3 {

    static boolean isNotBorder(int row, int col, int rows, int cols, int[][] mat) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        return false;

    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = Integer.MAX_VALUE;

        int[][] mat = new int[height][width];
        int totalnuts = nuts.length;

        mat[tree[0]][tree[1]] = 2;
        for(int i = 0 ; i < nuts.length; i++)
            mat[nuts[i][0]][nuts[i][1]] = 1;

        int treer = tree[0];
        int treec = tree[1];

        int[] nutsvisited = new int[totalnuts];

        int srow = squirrel[0];
        int scol = squirrel[1];

        Queue<PairSquirrel> q = new ArrayDeque<>();

        q.add(new PairSquirrel(new int[] { srow, scol, 0, 0 }, nutsvisited) ); // 0  nuts taken till now and 0 moves  new int[] { srow, scol, 0, 0 }

        while(!q.isEmpty()){

            PairSquirrel front = q.poll();
            int row = front.data[0];
            int col = front.data[1];
            int nutstaken = front.data[2];
            int movestillnow = front.data[3];

            if(mat[row][col] == 2 && nutstaken >= totalnuts){
                if(movestillnow < ans)
                    ans = movestillnow;
            }else{

                int [] visitedinthispath = front.visited;
                
                for(int i = 0; i < totalnuts; i++){
                    if(visitedinthispath[i] == 0){

                        int nutr = nuts[i][0];
                        int nutc = nuts[i][1];

                        int movestonut = Math.abs(row-nutr) + Math.abs(col-nutc);
                        int movestotree = Math.abs(nutr-treer) + Math.abs(nutc - treec);

                        int totalmovesthistime = movestonut+movestotree;

                        int[] copied = visitedinthispath.clone();
                        copied[i] = 1;
                        q.add(new PairSquirrel(new int[] { treer, treec, nutstaken+1, movestillnow + totalmovesthistime }, copied));

                    }
                }

            }

        }


        return ans;
    }

    public static void main(String[] args) {
        
    }
}

class PairSquirrel {
    public int[] data;
    public int[] visited;

    public PairSquirrel(int[] data, int[] visited) {
        this.data = data;
        this.visited = visited;
    }
}
