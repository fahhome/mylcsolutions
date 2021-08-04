package leetcode;

public class WC28P3 {
    public static int factorial(int n, int mod) {


        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = (fact% mod * i%mod)%mod;
        }
        return fact;
    }

    public static int powmod(int n, int mod){
        int powans = 3;

        for(int i = 1; i < n; i++){
            powans = (powans%mod * 3%mod)%mod;
        }

        return powans;
    }

    public static int checkRecord(int n) {

        int mod = 1000000007;

        int ans = ( (int)Math.pow(3, n)%mod - ( (factorial(n,mod) / 2%mod)%mod + ( (n-2)%mod * (factorial(n-3,mod))%mod  )%mod)*2%mod %mod ) %mod;

        return ans;
    }

    public static void main(String[] args) {
        int n = 10101;
        System.out.println(checkRecord(n));
    }
}
