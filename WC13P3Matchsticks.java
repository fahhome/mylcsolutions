package leetcode;
import java.util.*;


// After including hashcode() and equals()[ Right Click --> Source] the TLE for some test cases was removed .
// TLE --> [6,13,1,17,13,13,2,4,19,14,3,1,5,3,12]
public class WC13P3Matchsticks {

    public static boolean is_makesquare(int[] matchsticks,int l1, int l2, int l3, int l4, int index, int len, 
            Map<State, Boolean> memo){

        

        if(l1 == l2 && l2 == l3 && l3 == l4 && l1 != 0 && index >= len)
            return true;

        if(memo.containsKey(new State(index, l1, l2, l3, l4)))
                return memo.get(new State(index, l1, l2, l3, l4));

        boolean ans = false;

        for(int i = index ; i < len ; i++){
            if(is_makesquare(matchsticks, l1+matchsticks[index], l2, l3, l4, index+1, len, memo) || 
                    is_makesquare(matchsticks, l1, l2+matchsticks[index], l3, l4, index + 1, len, memo) ||
                    is_makesquare(matchsticks, l1, l2, l3+matchsticks[index], l4, index+1, len, memo) || 
                    is_makesquare(matchsticks, l1, l2, l3, l4+matchsticks[index], index+1, len, memo)){
                ans = true;
            }
        }


        State state = new State(index, l1, l2, l3,l4);
        memo.put(state, ans);

        return ans;

    }


    public static boolean makesquare(int[] matchsticks) {
        Map<State,Boolean> memo = new HashMap<>();
        return is_makesquare(matchsticks,0,0,0,0,0, matchsticks.length,memo);
    }

    public static void main(String[] args) {
        int[] matchsticks = { 6, 13, 1, 17, 13, 13, 2, 4, 19, 14, 3, 1, 5, 3, 12};
        System.out.println(makesquare(matchsticks));
    }

}

class State {
    int index; 
    int l1;
    int l2;
    int l3;
    int l4;

    public State(int index, int l1, int l2, int l3, int l4){
        this.index = index;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        result = prime * result + l1;
        result = prime * result + l2;
        result = prime * result + l3;
        result = prime * result + l4;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        if (index != other.index)
            return false;
        if (l1 != other.l1)
            return false;
        if (l2 != other.l2)
            return false;
        if (l3 != other.l3)
            return false;
        if (l4 != other.l4)
            return false;
        return true;
    }

}
