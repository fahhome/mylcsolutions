package leetcode;
import java.util.*;

// It results in integer overflow because even if a single integer is multiplied with a
// huge  number it results in a huge number and integer overflow. 
public String multiply(String num1, String num2) {
        
        int num1len = num1.length();
        int num2len = num2.length();
        int num1dec = Integer.parseInt(num1);
        
        List<String> rows = new LinkedList<>();
        for(int i = 0; i < num2len; i++){
            
            int row = num1dec * (Integer.parseInt(Character.toString(num2.charAt(num2len-i-1))));
            
            row = row * (int)Math.pow(10,i);
            
            rows.add(String.valueOf(row));
            
        }
        
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        while(true){
            
            int flag = 0;
            int sum = 0;
            for(String row : rows){
                if(i < row.length()){
                    flag = 1;
                    sum +=  ( (row.charAt(row.length() - i -1) - '0' ) );
                }
            }
            
            sum += carry;
            
            if(flag == 0){  
                if(carry != 0)
                    ans.insert(0,String.valueOf(carry));
                break;
            }else{
                ans.insert(0,String.valueOf(sum%10));
                carry = sum/10;
            }
            
            i++;
            
        }
        
        
        return new String(ans);
        
    }

}
