package leetcode;
import java.util.*;

//TLE with and without set
public class wc22p4 {

    public int findRotateSteps(String ring, String key) {
        int ans = 0;

        int ringlen = ring.length();
        int keylen = key.length();

        Queue<StateKey> q = new ArrayDeque<>();
        HashSet<StateKey> set = new HashSet<>();

        if(ring.charAt(0) == key.charAt(0)){
            List<Character> l1 = new LinkedList<>();
            l1.add(ring.charAt(0));
            q.add(new StateKey(l1, 0,1));
            set.add(new StateKey(l1, 0, 1));
        }else{
            List<Character> l1 = new LinkedList<>();
            q.add(new StateKey(l1, 0 ,0));
            set.add(new StateKey(l1, 0, 0));
        }
        

        while(!q.isEmpty()){

            StateKey front = q.poll();

            List<Character> keysofar = front.keysofar;
            int index = front.index;
            int stepssofar = front.stepssofar;
            int sizesofar = keysofar.size();

            if(sizesofar == keylen )
                return stepssofar;

            int currentindex = index;
            int clockwiseindex = (index+1)%ringlen;
            int anticlockwiseindex = (index + ringlen -1) % ringlen;

            
            char nextreqchar = key.charAt(sizesofar);

            if (ring.charAt(currentindex) == nextreqchar) {
                List<Character> nextkeyseq = new LinkedList<>(keysofar);
                nextkeyseq.add(nextreqchar);
                if(!set.contains(new StateKey(nextkeyseq, currentindex, stepssofar + 1))){
                    q.add(new StateKey(nextkeyseq, currentindex, stepssofar + 1));
                    set.add(new StateKey(nextkeyseq, currentindex, stepssofar + 1));
                }
                
            } else {

            }

            
            if(!set.contains(new StateKey(new LinkedList<>(keysofar), clockwiseindex, stepssofar + 1))){
                q.add(new StateKey(new LinkedList<>(keysofar), clockwiseindex, stepssofar + 1));
                set.add(new StateKey(new LinkedList<>(keysofar), clockwiseindex, stepssofar + 1));
            }



            if(!set.contains(new StateKey(new LinkedList<>(keysofar), anticlockwiseindex, stepssofar + 1))){
                q.add(new StateKey(new LinkedList<>(keysofar), anticlockwiseindex, stepssofar + 1));
                set.add(new StateKey(new LinkedList<>(keysofar), anticlockwiseindex, stepssofar + 1));
            }



        }   


        return ans;
    }


    public static void main(String[] args) {
        
    }
}

class StateKey{

    List<Character> keysofar;
    int index;
    int stepssofar;

    public StateKey(List<Character> keysofar, int index, int stepssofar){
        this.keysofar = keysofar;
        this.index = index;
        this.stepssofar = stepssofar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        result = prime * result + ((keysofar == null) ? 0 : keysofar.hashCode());
        result = prime * result + stepssofar;
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
        StateKey other = (StateKey) obj;
        if (index != other.index)
            return false;
        if (keysofar == null) {
            if (other.keysofar != null)
                return false;
        } else if (!keysofar.equals(other.keysofar))
            return false;
        if (stepssofar != other.stepssofar)
            return false;
        return true;
    }

}