package leetcode;
import java.util.*;

public class AmazonPS1P1 {

    public static void dfs(int curvertex, int [][] adjmatrix , int [] visited){

        for(int i = 0 ; i < visited.length; i++){

            if(i != curvertex && visited[i]  != 1 && adjmatrix[curvertex][i] == 1){
                visited[i] = 1;
                dfs(i, adjmatrix, visited);
            }

        }

    }


    public static boolean morethanOneComponent(int[][] adjmatrix , int n){

        boolean isMoreThanOneComponent = false;

        int [] visited = new int[n];

        for(int i = 0 ; i < n ; i++){

            if(visited[i] == 0 && i ){

            }else{

            }
        }


        return isMoreThanOneComponent;

    }



    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> anslist = new LinkedList<>();


        return anslist;

    }
    
    public static void main(String[] args) {
        
    }
}
