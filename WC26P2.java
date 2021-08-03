package leetcode;
import java.util.*;
public class WC26P2 {

    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }


    public int findLUSlength(String[] strs) {
        int len = strs[0].length();
        int ans = -1;
        LinkedHashMap<String,Integer> hmap = new LinkedHashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            if(hmap.containsKey(strs[i])){
                hmap.put(strs[i], hmap.get(strs[i]) + 1 );
            }else{
                hmap.put(strs[i],1);
            }
        }

        Map<String, Integer> lhp = new LinkedHashMap<>();

        hmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        
        for(Map.Entry<String,Integer> entry : lhp.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();

            if(val  > 1)
                break;

            int flag = 0;
            for(int i = 0; i < strs.length; i++){
                if(!strs[i].equals(key)){
                    if(isSubsequence(key, strs[i])){
                        flag = 1;
                        continue;
                    }
                }
            }

            if(flag == 0){
                if(key.length() > ans)
                    ans = key.length();
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
