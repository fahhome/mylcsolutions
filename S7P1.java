package leetcode;
import java.util.*;

// Rotting Oranges
// Important 2D array to list of list
// https://leetcode.com/problems/rotting-oranges/solution/
// Further optimization dont need to check totalRotten and prevRotten everytime, newState prevstate
// Just return if  the rottingProcesshasstopped or not and then adjust
public class S7P1 {

    public static int totalOranges(List<List<Integer>> state){
        int sum = 0;

        for(List<Integer> row : state){
            for(int val : row){
                if(val != 0)
                    sum++;
            }
        }

        return sum;
    }

    public static int totalRotten(List<List<Integer>> state){
        int sum = 0;

        for (List<Integer> row : state) {
            for (int val : row) {
                if (val == 2)
                    sum++;
            }
        }

        return sum;

    }

    public static boolean isSafe(int i, int j, List<List<Integer>> state){

        int m = state.size();
        int n = state.get(0).size();

        if( ( j-1 >= 0 && state.get(i).get(j-1) == 2 ) || (j+1 < n && state.get(i).get(j + 1) == 2) || ( i-1 >= 0 && state.get(i-1).get(j) == 2 )
                || ( i+1 < m && state.get(i+1).get(j) == 2 ) )
                return false;

        return true;
    }

    public static List<List<Integer>> propagateRot(List<List<Integer>> state, int m , int n){

        //List<List<Integer>> newState = new LinkedList<>(state); If you pass like this it modifies the state list also because its list of list , the innerlist is a reference

        List<List<Integer>> newState = new LinkedList<>();

        // Deep copy
        // Important
        for (List<Integer> sublist : state) {
            newState.add(new ArrayList<>(sublist));
        }

        for(int i = 0 ;i < m ; i++){
            for(int j = 0; j < n; j++){
                if(newState.get(i).get(j) == 1 && !isSafe(i, j, state) ){
                    newState.get(i).set(j, 2);
                }
            }
        }

        return newState;

    }

    public static int orangesRotting(int[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> initialState = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : ints) {
                list.add(i);
            }
            initialState.add(list);
        }
        

        int totalOranges = totalOranges(initialState);

        System.out.println(totalOranges);

        int initialRotten = totalRotten(initialState);

        if(totalOranges == initialRotten)
            return 0;

        int prevRotten = initialRotten;
        
        List<List<Integer>> newState = new LinkedList<>();

        int min = 1;
        for(min = 1 ; min < 100000; min++){
            newState = propagateRot(initialState, m, n);
            int rotten = totalRotten(newState);
            if(rotten == prevRotten || rotten == totalOranges )
                break;
            prevRotten = rotten;
            initialState  = newState;
        }

        if(totalOranges == totalRotten(newState))
            return min;


        return -1;

    }


    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}

