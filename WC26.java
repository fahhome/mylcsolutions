package leetcode;

public class WC26 {

    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public static void dfsb(String a, String b, int[] ans, int index, StringBuilder curstring) {
        if (index >= b.length())
            {
                if (curstring.length() > ans[0] && !isSubsequence(new String(curstring), a))
                    ans[0] = curstring.length();
                return;
            }

        if (!isSubsequence(new String(curstring), a)) {
            if (curstring.length() > ans[0])
                ans[0] = curstring.length();
        }

        dfsb(a, b, ans, index + 1, new StringBuilder(curstring.append(b.charAt(index))));
        dfsb(a, b, ans, index + 1, new StringBuilder(curstring));
    }

    public static void dfsa(String a, String b, int[]ans, int index, StringBuilder curstring){
        if(index >= a.length()){
            if (curstring.length() > ans[0] &&  !isSubsequence(new String(curstring), b))
                    ans[0] = curstring.length();
            return;
        }
            

        if(!isSubsequence(new String(curstring), b)){
            if(curstring.length() > ans[0])
                ans[0] = curstring.length();
        }
        
        dfsa(a, b, ans, index+1, new StringBuilder(curstring.append(a.charAt(index))));
        dfsa(a, b, ans, index+1, new StringBuilder(curstring));

    }

    public static int findLUSlength(String a, String b) {
        int []ans = new int[1];
        ans[0] = -1;


        dfsa(a, b, ans, 0, new StringBuilder());
        dfsb(a, b, ans, 0, new StringBuilder());

        return ans[0];
    }

    public static void main(String[] args) {
        String a = "aefawfawfawfaw";
        String b ="aefawfeawfwafwaef";

        System.out.println(findLUSlength(a, b));
    }
}
