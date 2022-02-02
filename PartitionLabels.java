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

// Alternate Approach

// public List<Integer> partitionLabels(String s) {
        
//         List<Integer> ans = new LinkedList<>();
//         HashMap<Character,int[]> hmap = new HashMap<>();
//         int len = s.length();
        
//         for(int i = 0; i < len ; i++){
            
//             char ch = s.charAt(i);
//             if(hmap.containsKey(ch)){
//                 hmap.get(ch)[1] = i;
//             }else{
//                 int[] arr = new int[2];
//                 arr[0] = i;
//                 hmap.put(ch,arr);
//             }
            
//         }
        
//         int curSI = 0;
//         int curEI = 1;
        
//         int currPartitionEndIdx = hmap.get(s.charAt(0))[1];
        
//         while(curEI < len){
            
//             while(curEI <= currPartitionEndIdx){
//                 if(hmap.get(s.charAt(curEI))[1] > currPartitionEndIdx)
//                     currPartitionEndIdx = hmap.get(s.charAt(curEI))[1];
                    
//                 curEI++;
//             }
            
//             if(curEI >= len)
//                 break;
            
//             ans.add(curEI - curSI);   
//             curSI = curEI;
//             currPartitionEndIdx = hmap.get(s.charAt(curEI))[1];
//             curEI = curSI + 1;
            
//         }
        
//         ans.add(curEI - curSI);
        
//         return ans;
        
//     }
