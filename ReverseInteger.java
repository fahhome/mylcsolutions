package leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        int sign1 = Integer.signum(x);

        if (x <= -2147483648)
            return 0;
        if (x > (2147483647))
            return 0;

        int num = 0;

        int posNumber = (sign1 > 0) ? x : (-1 * x);
        System.out.println(posNumber);
        while (posNumber > 0) {

            num = num * 10 + posNumber % 10;
            posNumber /= 10;

        }

        System.out.println(num);
        

        return (sign1 > 0) ? num : (-1 * num);

    }
    public static void main(String[] args) {
        
        System.out.println(reverse(123));
    }
}
