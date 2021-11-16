package leetcode;

import java.util.LinkedList;
import java.util.*;

public class S6P1 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;

        int [] ans = new int[l1];
        List<Integer> arr2list = new LinkedList<Integer>();
        for(int num : arr2)
            arr2list.add(num);
        List<Integer> uniquetoarr1 = new LinkedList<>();
        LinkedHashMap<Integer,Integer> freq = new LinkedHashMap<>();

        for(int num : arr1){
            if(arr2list.contains(num)){
                if(freq.containsKey(num)){
                    freq.put(num, freq.get(num) + 1);
                }else{
                    freq.put(num, 1);
                }
            }else{
                uniquetoarr1.add(num);
            }
        }


        int i = 0;
        for(int num : arr2){

            for(int j = 0 ; j < freq.get(num) ; j++){
                ans[i++] = num;
            }

        }

        Collections.sort(uniquetoarr1);

        for(int num : uniquetoarr1){
            ans[i++] = num;
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
    
}
