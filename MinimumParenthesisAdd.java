package leetcode;

import java.util.Stack;

public class MinimumParenthesisAdd {

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0 ; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else{
                if( !stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(')');
            }

        }
        return stack.size();
    }
    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }
    
}
