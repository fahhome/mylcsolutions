package leetcode;

public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {

        int l1 = name.length();
        int l2 = typed.length();

        int i=0,j=0;

        while(i < l1 && j < l2){
            char nchar = name.charAt(i);
            char tchar = typed.charAt(j);
            if(nchar == tchar){
                i++;
                j++;
            }else{
                if(i > 0 && tchar == name.charAt(i-1))
                    j++;
                else
                    return false;
            }

        }
        if(i == l1){
            while(j < l2){
                if(typed.charAt(j) != name.charAt(i-1))
                    return false;
                j++;
            }
            return true;
        }
            
        return false;
    }
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";

        System.out.println(isLongPressedName(name, typed));
    }
}

// Alternate solution

// public boolean isLongPressedName(String name, String typed) {
//         String build = "";  
//         int nlen = name.length();
//         int tlen = typed.length();
//         int i = 0;
//         int j = 0;
        
//         char prev = '1';
        
//         while(i <  nlen && j < tlen){
            
//             char nch = name.charAt(i);           
//             char tch = typed.charAt(j);
//             if(nch != tch)
//             {
//                 while(j < tlen && typed.charAt(j) == prev)
//                     j++;
//             }
            
//             if(j >= tlen)
//                 return false;
//             if(typed.charAt(j) != nch)
//                 return false;
            
//             prev = nch;
//             i++;
//             j++;
            
//         }
        
        
//         if(i == nlen && j != tlen){
//             while(j < tlen){
                
//                 if(typed.charAt(j) != prev)
//                     return false;
//                 j++;
//             }
//         }
        
//         if( i != nlen && j == tlen)
//             return false;
        
//         return true;
        
        
//     }