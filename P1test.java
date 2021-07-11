package leetcode;

public class P1test {

    public static int countTriples(int n) {
        int ans = 0;

        for(int a = 1 ; a <= n ; a++)
            for(int b= a; b<=n; b++)
                for(int c= b; c <= n; c++){
                    if(a*a + b*b == c*c)
                        ans++;
                }

        return ans*2;

    }


    public static void main(String[] args) {
        System.out.println(countTriples(25));
    }
    
}
