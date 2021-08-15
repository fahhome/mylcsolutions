package leetcode;
import java.util.*;

// important
// TLE with DFS and MLE with BFS So with BFS if TimeComplexity is exponential then do not go with BFS and DFS but observe the problem for a trick
// So whenever it does not work
// Here Summations of TOFROM between tree to nuts do not depend on the order of the nut we pick at each stage 
// Soln --> SquirrelSimulation.java


public class SquirrelNuts {

    public static void dfs(int row, int col, int height, int width, int[] tree, int[] squirrel, int[][] nuts, int totalnuts, LinkedList<Integer> nutsvisited, int movestillnow,int[] ans){
        if(nutsvisited.size() == totalnuts){
            if(ans[0] > movestillnow)
                ans[0] = movestillnow;
        }else{

            for(int i = 0; i < totalnuts; i++){
                if(!nutsvisited.contains(i)){

                    int nutr = nuts[i][0];
                    int nutc = nuts[i][1];

                    int movestonut = Math.abs(row-nutr) + Math.abs(col-nutc);
                    int movestotree = Math.abs(nutr-tree[0]) + Math.abs(nutc - tree[1]);

                    int totalmovesthistime = movestonut+movestotree;

                    LinkedList<Integer> newvisited = new LinkedList<>(nutsvisited);
                    newvisited.add(i);
                    dfs(tree[0], tree[1], height, width, tree, squirrel, nuts, totalnuts, newvisited, movestillnow + totalmovesthistime, ans);

                }
            }

        }
    }

    public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int[] ans = {Integer.MAX_VALUE};

        int[][] mat = new int[height][width];
        int totalnuts = nuts.length;

        mat[tree[0]][tree[1]] = 2;
        for (int i = 0; i < nuts.length; i++)
            mat[nuts[i][0]][nuts[i][1]] = 1;

        int treer = tree[0];
        int treec = tree[1];


        int srow = squirrel[0];
        int scol = squirrel[1];

        LinkedList<Integer> nutsvisited = new LinkedList<>();
        
        dfs(0, 0, height, width, tree, squirrel, nuts, totalnuts, nutsvisited, 0, ans);

        return ans[0];
    }


    public static void main(String[] args) {
        
    }
}


class PairSquirrelDFS {
    public int[] data;
    public int[] visited;

    public PairSquirrelDFS(int[] data, int[] visited) {
        this.data = data;
        this.visited = visited;
    }
}