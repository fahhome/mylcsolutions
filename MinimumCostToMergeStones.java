package leetcode;

import java.util.*;

//  After including the memoobject in this way test cases passed has increased

public class MinimumCostToMergeStones {


    public static int minCost(List<Integer> remainingStones, int k, int sumTillNow, 
            LinkedHashMap<MemoObject, Integer> lhmap){

        int curSize = remainingStones.size();

        if(curSize == 1)
            return sumTillNow;
        
        if(curSize < k)
            return Integer.MAX_VALUE;

        MemoObject mobj = new MemoObject(remainingStones, sumTillNow);

        if(lhmap.containsKey(mobj))
                return lhmap.get(mobj);
        
        int minCostFromHere = Integer.MAX_VALUE;

        for(int i = k-1; i < curSize ; i++){

            List<Integer> newRS = new LinkedList<>();
            // Add the stones before the piles aggregation in this iteration
            
            for(int j = 0; j <= (i-k); j++){
                newRS.add(remainingStones.get(j));
            }

            int sumOfPiles = 0;
            for(int j = i ; j >= (i - k + 1); j--){
                sumOfPiles += remainingStones.get(j);
            }

            newRS.add(sumOfPiles);

            for(int j = i+1 ; j < curSize; j++)
                newRS.add(remainingStones.get(j));
            
            int candidateMin = minCost(newRS, k, sumTillNow + sumOfPiles, lhmap);

            if(candidateMin < minCostFromHere)
                minCostFromHere = candidateMin;

        }

        lhmap.put(mobj, minCostFromHere);


        return minCostFromHere;
    }

    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        List<Integer> remainingStones = new LinkedList<>();
        for(int i = 0 ; i < n; i++)
            remainingStones.add(stones[i]);

        LinkedHashMap<MemoObject, Integer> lhmap = new LinkedHashMap<>();

        int ans =  minCost(remainingStones, k, 0, lhmap);

        if(ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    
    }

    public static void main(String[] args) {

        int [] stones = { 3, 5, 1, 2, 6};
        int k = 3;

        System.out.println(mergeStones(stones, k));
        
    }


}

class MemoObject{
    List<Integer> remainingStones;
    int sumTillNow;
    public MemoObject(List<Integer> remainingStones, int sumTillNow){
        this.remainingStones = new LinkedList<>(remainingStones);
        this.sumTillNow = sumTillNow;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((remainingStones == null) ? 0 : remainingStones.hashCode());
        result = prime * result + sumTillNow;
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
        MemoObject other = (MemoObject) obj;
        if (remainingStones == null) {
            if (other.remainingStones != null)
                return false;
        } else if (!remainingStones.equals(other.remainingStones))
            return false;
        if (sumTillNow != other.sumTillNow)
            return false;
        return true;
    }
    
}
