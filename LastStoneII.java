package leetcode;
import java.util.*;

// O(n^2 * 2^n)
public class LastStoneII {

    public static int smwt(List<Integer> remstones, Map<List<Integer>, Integer> memo) {

        if (memo.containsKey(remstones))
            {
                System.out.println("Memo blocked entered");
                return memo.get(remstones);
            }
        int cursize = remstones.size();
        if (cursize == 0)
            return 0;
        if (cursize == 1)
            return remstones.get(0);

        int minwt = Integer.MAX_VALUE;
        for (int i = 0; i < cursize; i++) {
            for (int j = i + 1; j < cursize; j++) {
                int w1 = remstones.get(i);
                int w2 = remstones.get(j);

                List<Integer> nl = new LinkedList<>(remstones);
                nl.remove(i);
                nl.remove(j - 1);

                int minFromTheseTwo = Integer.MAX_VALUE;

                if (w1 == w2) {
                    minFromTheseTwo = smwt(nl, memo);
                }

                else {
                    nl.add(Math.abs(w1 - w2));
                    minFromTheseTwo = smwt(nl, memo);
                }

                minwt = Math.min(minFromTheseTwo, minwt);
            }
        }

        memo.put(new LinkedList<>(remstones), minwt);
        return minwt;

    }

    public static int lastStoneWeightII(int[] stones) {
        int len = stones.length;

        List<Integer> remstones = new LinkedList<>();
        for (int i = 0; i < len; i++)
            remstones.add(stones[i]);

        Map<List<Integer>, Integer> memo = new HashMap<>();

        return smwt(remstones, memo);
    }

    public static void main(String[] args) {
        int [] stones = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
    
}
