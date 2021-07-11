package leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class GenerateParenthesis {

    public static String getStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public static boolean isValidParenthesis(String s){

        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i= 0 ; i < len; i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else
            {
                if(stack.isEmpty())
                    return false;
                if(stack.pop() == ')')
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }

    public static void dfs(List<Character> possiblesoln, Set<String> set, int len, String ps){

        if(possiblesoln.size() == len){
            if(isValidParenthesis(getStringRepresentation(possiblesoln)))
                set.add(getStringRepresentation(possiblesoln));
        }
        else{
            for(int i = 0; i < ps.length(); i++){
                possiblesoln.add(ps.charAt(i));
                dfs(possiblesoln, set, len, ps);
                possiblesoln.remove(possiblesoln.size() - 1);
            }
        }

    }

    public static List<String> generateParenthesis(int n) {

        String ps = "()";
        List<Character> possiblesoln = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        Set<String> set = new LinkedHashSet<>();
        dfs(possiblesoln, set, n*2, ps);
        ans = new LinkedList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
