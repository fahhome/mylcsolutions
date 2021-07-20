package leetcode;
import java.util.*;


// After including hashcode() and equals()[ Right Click --> Source] the TLE for some test cases were removed .
// TLE --> [6,13,1,17,13,13,2,4,19,14,3,1,5,3,12]
// Including the for loop oin line 30 is wrong logic , O(N*4^n) to O(4^n)
public class WC13P3Matchsticks {

    public static boolean is_makesquare(int[] matchsticks,int l1, int l2, int l3, int l4, int index, int len, 
            Map<State, Boolean> memo, int sidelen){

        

        if(l1 == l2 && l2 == l3 && l3 == l4 && l1 != 0 && index >= len)
            return true;

        if(l1 > sidelen || l2 > sidelen || l3 > sidelen || l4 > sidelen){
            State state = new State(l1, l2, l3, l4);
            memo.put(state, false);
            return false;
        }

        if(memo.containsKey(new State(l1, l2, l3, l4)))
                return memo.get(new State(l1, l2, l3, l4));


        boolean ans = false;

        // for(int i = index ; i < len ; i++){ --> You don't require this for loop , increases time complexity and wrong logic 
            if(is_makesquare(matchsticks, l1+matchsticks[index], l2, l3, l4, index+1, len, memo,sidelen) || 
                    is_makesquare(matchsticks, l1, l2+matchsticks[index], l3, l4, index + 1, len, memo, sidelen) ||
                    is_makesquare(matchsticks, l1, l2, l3+matchsticks[index], l4, index+1, len, memo, sidelen) || 
                    is_makesquare(matchsticks, l1, l2, l3, l4+matchsticks[index], index+1, len, memo, sidelen)){
                ans = true;
            }
        //}


        State state = new State(l1, l2, l3,l4);
        memo.put(state, ans);

        return ans;

    }


    public static boolean makesquare(int[] matchsticks) {
        Map<State,Boolean> memo = new HashMap<>();
        int len = matchsticks.length;
        int perimeter = 0;

        for(int i=0; i < len ; i++){
            perimeter += matchsticks[i];
        }

        if(perimeter % 4 != 0)
            return false;
        
        int sidelen = perimeter / 4;
        
        return is_makesquare(matchsticks,0,0,0,0,0, matchsticks.length,memo, sidelen);
    }

    public static void main(String[] args) {
        int[] matchsticks = {6,13,1,17,13,13,2,4,19,14,3,1,5,3,12};
        System.out.println(makesquare(matchsticks));
    }

}

class State {
    int l1;
    int l2;
    int l3;
    int l4;

    public State(int l1, int l2, int l3, int l4){
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
