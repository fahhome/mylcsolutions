package leetcode;
import java.util.*;



// Set takes longer time O(n) and hence slower than my pother solution in WC2P2
public class EliminationGameUsingSet {

    public static int lastRemaining(int n) {


        int ltor = 1;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 1; i<= n ; i++){
            set.add(i);
        }
        Iterator<Integer> iterator = set.descendingIterator();

        while(set.size() > 1){
            if(ltor % 2  == 1){
                iterator = set.iterator();
                boolean isOther = true ;
                while(iterator.hasNext()){
                    iterator.next();
                    if (isOther == true)
                        iterator.remove();
                    isOther = !isOther;
                }
                

            }else{
                iterator = set.descendingIterator();
                boolean isOther = true ;
                while(iterator.hasNext()){
                    iterator.next();
                    if(isOther == true)
                        iterator.remove();
                    isOther = !isOther;
                }
            }
            ltor = (ltor + 1) % 2;
        }

        return set.pollFirst();

    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(332));
    }
    
}
