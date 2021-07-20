package leetcode;
import java.util.*;


//https://leetcode.com/contest/leetcode-weekly-contest-17/problems/the-maze-iii/
public class MazeIII {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<State> q = new ArrayDeque<>();
        int rows = maze.length;
        int cols = maze[0].length;
        q.add(new State(new LinkedList<>(),0,ball[0],ball[1]));

        while(!q.isEmpty()){

            State front = q.poll();

            int r = front.row;
            int c = front.col;
            int d = front.distance;
            LinkedList<Character> s = front.str;

            

        }

        if(q.isEmpty())
            return "impossible";

    }

    public static void main(String[] args) {
        
    }
    
}

class State{

    LinkedList<Character> str ;
    int distance ;
    int row;
    int col; 

    public State(LinkedList<Character> str, int distance, int row, int col){
        this.str = str;
        this.distance = distance;
        this.row = row;
        this.col = col;
    }

}
