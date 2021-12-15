package leetcode;

import java.util.LinkedList;
import java.util.List;

// new List<>() can be applied to int [] or other collections like set but not string
// NOTE:- without the visited memo it is TLE .
public class Wordbreak {

    public static void dfs(String s , List<String> wordDict , int start ,  boolean[] ans, int[] visited){
        if(start == s.length()){
            ans[0] = true;
            return;
        }

        visited[start] = 1 ;


        int i = start + 1 ;
        while (i <= s.length()) {

            if(wordDict.contains(s.substring(start,i)) && visited[i] == 0){
                dfs(s, wordDict, i, ans, visited);
            }

            i++;
        }


    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int start = 0;
        boolean[] ans = new boolean[1];
        int [] visited = new int[len+2];

        if(len == 1 && wordDict.contains(s))
            return true;
        visited[0] = 1;
        dfs(s, wordDict, start, ans, visited);
    
        return ans[0];
    }
    public static void main(String[] args) {

        String s = "leetcode";
        String [] words = {"leet","code"};
        List<String> wordDict = new LinkedList<>();
        for(String word : words)
            wordDict.add(word);

        System.out.println(wordBreak(s, wordDict));
        
    }
}
