package leetcode;

import java.util.*;

//https://leetcode.com/submissions/detail/596817556/
public class MaximumUnitsOnATruck {
    
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            int tbt = boxTypes.length;
            List<ArrPair> arrpairs = new LinkedList<>();
            for (int i = 0; i < tbt; i++) {
                ArrPair arrpair = new ArrPair(boxTypes[i][0], boxTypes[i][1]);
                arrpairs.add(arrpair);
            }

            int sum = 0;

            // Comparator<ArrPair> cmp = new Comparator<ArrPair>((p1,p2) -> p2.noupb -
            // p1.noupb); // It does not work like that you have to override the function and not use inline statement like this

            Collections.sort(arrpairs, (p1, p2) -> p2.noupb - p1.noupb);

            for (ArrPair pair : arrpairs) {
                if (truckSize <= 0)
                    break;

                int boxesUsed = Math.min(truckSize, pair.nob);

                sum += boxesUsed * pair.noupb;

                truckSize -= boxesUsed;
            }

            return sum;
        }
    

    
}

class ArrPair {
    int nob;
    int noupb;

    public ArrPair(int nob, int noupb) {
        this.nob = nob;
        this.noupb = noupb;
    }

}
