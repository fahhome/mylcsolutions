package leetcode;
import java.util.*;
public class WC21P3 {

    public static String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        LinkedHashMap<Character, Integer> freqmap = new LinkedHashMap<>();

        int len = s.length();

        for(int i =0 ; i < len; i++){
            if(freqmap.containsKey(s.charAt(i))){
                freqmap.put(s.charAt(i), freqmap.get(s.charAt(i)) + 1 );
            }else{
                freqmap.put(s.charAt(i), 1);
            }
        }

        Comparator<String> cmp = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                // TODO Auto-generated method stub
                if (s1.length() < s2.length())
                    return 1;
                else if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }

                return -1;
            }

        };

        Collections.sort(dictionary,cmp);

        for(String dstr : dictionary){

            int lend = dstr.length();

            int flag = 1;

            int lastindex = s.indexOf(dstr.charAt(0)) + 1;

            if(lastindex == 0)
                flag = 0;

            int j = 1;
            for(j = 1; j < lend; j++){
                
                int found = 0;
                while(lastindex < len){
                    if(s.charAt(lastindex) == dstr.charAt(j))
                        {
                            found = 1;
                            lastindex++;
                            break;
                        }
                    lastindex++;
                }

                if(lastindex == len && found ==0)
                    flag = 0;

            }


            if(flag == 1){
                ans = dstr;
                return ans;

            }


        }


        return ans;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new LinkedList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(findLongestWord(s, dictionary));
    }
}
