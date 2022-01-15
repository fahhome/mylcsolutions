package leetcode;
import java.util.*;

// Variation of Longest Substring with atmost two distinct characters problem
public class FruitsIntoBaskets {
    class Solution {

        public int totalFruit(int[] fruits) {
            int len = fruits.length;
            HashMap<Integer, Integer> freqmap = new HashMap<>();// freqmap of characters currently present in the dq
            HashSet<Integer> uniqueFruits = new HashSet<>();
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            int ans = 0;

            for (int num : fruits) {

                if (uniqueFruits.size() == 2 && !uniqueFruits.contains(num)) {

                    while (uniqueFruits.size() == 2) {

                        int poppedfruit = dq.pollFirst();
                        freqmap.put(poppedfruit, freqmap.getOrDefault(poppedfruit, 0) - 1);
                        if (freqmap.get(poppedfruit) == 0)
                            uniqueFruits.remove(poppedfruit);

                    }

                }

                dq.addLast(num);
                uniqueFruits.add(num);
                freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);

                if (dq.size() > ans)
                    ans = dq.size();

            }

            return ans;

        }

    }
    public static void main(String[] args) {
        
    }
}
