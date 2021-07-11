package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// Convert Character to Integer
// Convert Character to String
public class PhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        int len = digits.length();


        if(digits.length() == 1){
            String str1 = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
            for(int i = 0 ; i < str1.length(); i++){

                String putstr = String.valueOf(str1.charAt(i));
                ans.add(putstr);

            }
        }
        else if(digits.length() == 2){
            String str1 = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
            String str2 = map.get(Integer.parseInt(String.valueOf(digits.charAt(1))));

            for(int i = 0 ; i < str1.length() ; i++){
                for(int j=0 ; j < str2.length() ; j++){
                    String putstr = String.valueOf(str1.charAt(i))  +  String.valueOf(str2.charAt(j)) ;
                    ans.add(putstr); 
                }
            }
        }

        else if(digits.length() == 3){
            String str1 = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
            String str2 = map.get(Integer.parseInt(String.valueOf(digits.charAt(1))));
            String str3 = map.get(Integer.parseInt(String.valueOf(digits.charAt(2))));

            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    for(int k = 0 ; k< str3.length(); k++){
                        String putstr = String.valueOf(str1.charAt(i)) + String.valueOf(str2.charAt(j)) + String.valueOf(str3.charAt(k));
                        ans.add(putstr);
                    }      
                }
            }
        }

        else if(digits.length() == 4){
            String str1 = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
            String str2 = map.get(Integer.parseInt(String.valueOf(digits.charAt(1))));
            String str3 = map.get(Integer.parseInt(String.valueOf(digits.charAt(2))));
            String str4 = map.get(Integer.parseInt(String.valueOf(digits.charAt(3))));

            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    for (int k = 0; k < str3.length(); k++) {
                        for(int l=0; l < str4.length(); l++){
                            String putstr = String.valueOf(str1.charAt(i)) + String.valueOf(str2.charAt(j))
                                    + String.valueOf(str3.charAt(k)) + String.valueOf(str4.charAt(l));
                            ans.add(putstr);
                        }
                    }
                }
            }
        }
        else{

        }


        return ans ;

    }
    
    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));
    }
}
