package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minlen = Integer.MAX_VALUE;
        String minstr = "";
        for (String str : strs) {
            if (str.length() < minlen) {
                minlen = str.length();
                minstr = str;
            }
        }
        int i = 0;
        for (; i < minlen; i++) {

            char ch = minstr.charAt(i);

            int flag = 0;
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1)
                break;

        }

        return minstr.substring(0, i);
    }
}


//PREV SOLUTION
// public String longestCommonPrefix(String[] strs) {
//         int minlen = Integer.MAX_VALUE;
//         String minstr = "";
//         for(String str : strs){
//             if(str.length() < minlen)
//             {
//                 minlen = str.length();
//                 minstr = str;
//             }
//         }
//         int i = 0;
//         for( ; i < minlen; i++){
                
//             char ch = minstr.charAt(i);
            
//             int flag = 0;
//             for(String str : strs){
//                 if(str.charAt(i) != ch)
//                 {
//                     flag = 1;
//                     break;
//                 }
//             }
            
//             if(flag == 1)
//                 break;
            
//         }
        
//         return minstr.substring(0,i);
//     }
