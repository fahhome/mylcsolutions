package leetcode;
import java.util.*;
public class WC18AP1 {
    
    public static String[] findWords(String[] words) {
        List<String> anslist = new LinkedList<>();

        String frow = "qwertyuiop";
        String srow = "asdfghjkl";
        String trow = "zxcvbnm";

        int nwords = words.length;

        for(int i = 0 ; i < nwords ; i++){
            int []nrowsused = new int[3];

            String teststr = words[i].toLowerCase();

            for(int j = 0 ;  j < teststr.length(); j++){
                if(frow.indexOf(teststr.charAt(j)) >= 0){
                    nrowsused[0] = 1;
                }else if(srow.indexOf(teststr.charAt(j)) >= 0){
                    nrowsused[1] = 1;
                }else{
                    nrowsused[2] = 1;
                }
            }

            int totalrowsused = 0;
            for(int k = 0 ; k < 3; k++){
                if(nrowsused[k] == 1)
                    totalrowsused++;
            }

            if(totalrowsused == 1)
                anslist.add(teststr);


        }

        String [] ans = new String[anslist.size()];

        for(int i = 0 ; i < anslist.size(); i++)
            ans[i] = anslist.get(i);

        
        return ans;

    }

    public static void main(String[] args) {
        String [] words = {"omk"};
        System.out.println(findWords(words).length);

    }

}
