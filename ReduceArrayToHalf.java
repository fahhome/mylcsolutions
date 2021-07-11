package leetcode;
import java.util.*;
public class ReduceArrayToHalf {
    public static int minSetSize(int[] arr) {

        int len = arr.length;
        int sum = 0;
        int ans = 0;
        int halflen = len / 2;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }

        }

        Map<Integer, Integer> lhp = new LinkedHashMap<>();

        freqMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        for (Map.Entry<Integer, Integer> entry : lhp.entrySet()) {
            if (sum >= halflen)
                break;
            sum += entry.getValue();
            ans++;
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
