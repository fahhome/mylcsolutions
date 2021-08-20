package leetcode;
import java.util.*;

public class WC253P4 {

    public int minSwaps(String s) {
        int n = s.length(); 

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == ']'){
                if(!stack.isEmpty()  && stack.peek() == '[')
                    stack.pop();
            }else{
                stack.push('[');
            }
        }

        return (int) Math.ceil(stack.size()/2);
    }

    public static void main(String[] args) {
        
    }
}
