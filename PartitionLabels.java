package leetcode;
import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        List<Integer> ans = new LinkedList<>();

        HashMap<Character, Integer> lidxmap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            lidxmap.put(ch, i);
        }

        int i = 0;

        while (i < len) {
            int curparsize = 0;
            int j = i;
            int curparendidx = lidxmap.get(s.charAt(0));
            while (j < len && j <= curparendidx) {
                char ch = s.charAt(j);
                if (lidxmap.get(ch) > curparendidx)
                    curparendidx = lidxmap.get(ch);
                curparsize++;
                j++;
            }

            ans.add(curparsize);
            i = j;
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
