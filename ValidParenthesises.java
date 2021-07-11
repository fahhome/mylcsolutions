package leetcode;
import java.util.*;

public class ValidParenthesises {

    public Character getReverseCharOf(Character c) {
        if (c == ')')
            return '(';
        else if (c == '}')
            return '{';
        else
            return '[';
    }

    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != getReverseCharOf(s.charAt(i)))
                    return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        
    }
    
}
