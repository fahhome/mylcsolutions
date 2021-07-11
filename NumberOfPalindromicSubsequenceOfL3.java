package leetcode;
import java.util.*;

//TLE --> instead of storing all the occurences store only first and last occurence
// ACCEPTED After changing between lines 23 and 26
//https://leetcode.com/contest/weekly-contest-249/problems/unique-length-3-palindromic-subsequences/
public class NumberOfPalindromicSubsequenceOfL3 {

    public static int countPalindromicSubsequence(String s) {

        int len = s.length();

        Set<String> uniquesubseq = new HashSet<>();
        Map<Character,List<Integer>> map = new HashMap<>();

        char[] indexmap = new char[len];

        for(int i = 0 ; i < len ; i++){
            indexmap[i] = s.charAt(i);
            char curchar = s.charAt(i);

            if(map.containsKey(curchar)){
                List<Integer> list = map.get(curchar);
                if(list.size() == 1)
                    list.add(i);
                else{
                    list.remove(list.size() -1);
                    list.add(i);
                }
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(curchar, list);
            }
        }



        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            char key = entry.getKey();
            List<Integer> value = map.get(key);
            // Collections.sort(value);

            // int minv = value.get(0);
            // int maxv = value.get(value.size() -1 );

            if(value.size() < 2)
                continue;
            
            for(int i = 0 ; i < value.size(); i++)
                for(int j = i+1; j < value.size(); j++){
                    if(value.get(j) - value.get(i) > 1){
                        for(int k = value.get(i)+1 ; k < value.get(j) ; k++){
                            String posstr = Character.toString(key) + Character.toString(indexmap[k]) + Character.toString(key);
                            uniquesubseq.add(posstr);
                        }
                    }
                }

            

            

        }




        return uniquesubseq.size() ;

    }

    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));

    }
    
}
